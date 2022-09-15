import com.android.build.gradle.AppPlugin
import com.android.build.gradle.LibraryPlugin

plugins {
    id(libs.versions.gradlePlugins.maven.publish.get())
    alias(libs.plugins.android).apply(false)
    alias(libs.plugins.library).apply(false)
    alias(libs.plugins.kotlinAndroid).apply(false)
    alias(libs.plugins.versionCatalogUpdate)
    alias(libs.plugins.versionsBenManes)
}

versionCatalogUpdate {
    sortByKey.set(false)

    keep {
        // keep versions without any library or plugin reference
        keepUnusedVersions.set(true)
        // keep all libraries that aren't used in the project
        keepUnusedLibraries.set(true)
        // keep all plugins that aren't used in the project
        keepUnusedPlugins.set(true)
    }
}


tasks.withType<com.github.benmanes.gradle.versions.updates.DependencyUpdatesTask> {
    resolutionStrategy {
        componentSelection {
            all {
                when {
                    isNonStable(candidate.version) && !isNonStable(currentVersion) -> {
                        reject("Updating stable to non stable is not allowed")
                    }
                    candidate.module == "kotlin-gradle-plugin" && candidate.version != libs.versions.kotlin.get() -> {
                        reject("Keep Kotlin version on the version specified in libs.versions.toml")
                    }
                    // KSP and KAPT versions are compound versions, starting with the kotlin version
                    candidate.group == "com.google.devtools.ksp" && !candidate.version.startsWith(libs.versions.kotlin.get()) -> {
                        reject("KSP needs to stick to Kotlin version")
                    }
                    candidate.group == "org.jetbrains.kotlin.kapt" && !candidate.version.startsWith(libs.versions.kotlin.get()) -> {
                        reject("KAPT needs to stick to Kotlin version")
                    }
                }
            }
        }
    }
}

fun isNonStable(version: String): Boolean {
    val stableKeyword = listOf("RELEASE", "FINAL", "GA").any { version.toUpperCase().contains(it) }
    val regex = "^[0-9,.v-]+(-r)?$".toRegex()
    val isStable = stableKeyword || regex.matches(version)
    return isStable.not()
}

subprojects {
    plugins.matching { anyPlugin -> supportedPlugins(anyPlugin) }.whenPluginAdded {
        val packageName = libs.versions.app.version.groupId.get()

        when (this) {
            is AppPlugin -> {
                configure<com.android.build.gradle.BaseExtension> {
                    namespace = packageName
                    defaultConfig {
                        applicationId = libs.versions.app.version.appId.get()
                    }
                }
            }
            is LibraryPlugin -> {
                configure<com.android.build.gradle.BaseExtension> {
                    namespace = packageName.plus(path.replace(":", "."))
                }
            }
        }
        configure<com.android.build.gradle.BaseExtension> {
            setCompileSdkVersion(project.libs.versions.app.build.compileSDKVersion.get().toInt())
            defaultConfig {
                minSdk = project.libs.versions.app.build.minimumSDK.get().toInt()
                targetSdk = project.libs.versions.app.build.targetSDK.get().toInt()
                versionName = project.libs.versions.app.version.versionName.get()
                versionCode = project.libs.versions.app.version.versionCode.get().toInt()
                testInstrumentationRunner = project.libs.versions.app.build.testRunner.get()

                vectorDrawables {
                    vectorDrawables.useSupportLibrary = true
                }
            }

            this@subprojects.addCompose(this)

            dependencies {
                add("androidTestImplementation", libs.bundles.androidTest)
                add("testImplementation", libs.bundles.unitTest)
                add("testRuntimeOnly", libs.testImplementation.runtime.jupiter.engine)
                add("debugImplementation", libs.testImplementation.compose.manifest)
            }

            compileOptions {
                sourceCompatibility = JavaVersion.VERSION_11
                targetCompatibility = JavaVersion.VERSION_11
            }

            tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
                kotlinOptions.jvmTarget = project.libs.versions.app.build.kotlinJVMTarget.get()
                kotlinOptions.freeCompilerArgs = listOf(
                    "-opt-in=kotlin.RequiresOptIn",
                    "-opt-in=kotlinx.coroutines.ExperimentalCoroutinesApi",
                    "-opt-in=kotlinx.coroutines.FlowPreview",
                    "-opt-in=androidx.compose.animation.ExperimentalAnimationApi",
                    "-opt-in=androidx.compose.ui.ExperimentalComposeUiApi",
                    "-opt-in=androidx.compose.material.ExperimentalMaterialApi",
                    "-opt-in=androidx.lifecycle.compose.ExperimentalLifecycleComposeApi",
                    "-opt-in=androidx.compose.foundation.ExperimentalFoundationApi",
                    "-Xcontext-receivers"
                )
            }

            plugins.withType<LibraryPlugin> {
                configure<com.android.build.gradle.LibraryExtension> {
                    defaultConfig {
                        consumerProguardFiles("consumer-rules.pro")
                    }
                    buildTypes {
                        getByName("debug") {
                            isMinifyEnabled = false
                        }
                        getByName("release") {
                            isMinifyEnabled = true
                            proguardFiles(
                                getDefaultProguardFile("proguard-android-optimize.txt"),
                                "proguard-rules.pro"
                            )
                        }
                    }
                }
            }

            tasks.withType<org.jetbrains.kotlin.gradle.internal.KaptWithoutKotlincTask>()
                .configureEach {
                    kaptProcessJvmArgs.add("-Xmx512m")
                }

            plugins.withType<org.jetbrains.kotlin.gradle.internal.Kapt3GradleSubplugin>() {
                configure<org.jetbrains.kotlin.gradle.plugin.KaptExtension>() {
                    useBuildCache = true
                    correctErrorTypes = true
                }
            }

            testOptions.unitTests.all {
                it.apply {
                    useJUnitPlatform()
                    testLogging {
                        events("passed", "failed", "skipped", "standardOut", "standardError")
                    }
                }
            }

            packagingOptions {
                resources {
                    excludes += setOf("META-INF/AL2.0", "META-INF/LGPL2.1")
                }
            }

            buildFeatures.apply {
                aidl = false
                renderScript = false
                resValues = false
                shaders = false
                buildConfig = false
            }

            tasks.register("testAll") {
                dependsOn("test", "connectedAndroidTest")
                group = "custom_tasks"
                description = "Run all tests"
            }
        }
    }
}

fun Project.addCompose(baseExtension: com.android.build.gradle.BaseExtension) {
    baseExtension.buildFeatures.compose = true

    baseExtension.composeOptions {
        kotlinCompilerExtensionVersion = project.project.libs.versions.composeCompiler.get()
    }

    project.dependencies {
        add("implementation", libs.compose.runtime)
    }
}

fun supportedPlugins(anyPlugin: Plugin<*>?) =
    anyPlugin is AppPlugin || anyPlugin is LibraryPlugin


afterEvaluate {
    plugins.matching { anyPlugin -> anyPlugin is LibraryPlugin }.whenPluginAdded {
        group = libs.versions.app.version.gihtubId.get()

        publishing {
            publications {
                create<MavenPublication>("release") {
                    from(components.getByName("release"))
                    groupId = libs.versions.app.version.groupId.get()
                    artifactId = name
                    version = libs.versions.app.version.versionName.get()
                }
            }
        }
    }
}