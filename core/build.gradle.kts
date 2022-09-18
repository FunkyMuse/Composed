plugins {
    alias(libs.plugins.library)
    alias(libs.plugins.kotlinAndroid)
    id(libs.versions.gradlePlugins.maven.publish.get())
}

dependencies {
    implementation(libs.bundles.compose)
    debugImplementation(libs.bundles.compose.preview)

    implementation(libs.bundles.lifecycle)
    implementation(libs.androidx.saved.state)
    androidTestImplementation(libs.androidx.androidTestImplementation.test.core)
    androidTestImplementation(libs.androidx.androidTestImplementation.test.rules)
}

val sourcesJar by tasks.creating(Jar::class) {
    archiveClassifier.set("sources")
    from(android.sourceSets.getByName("main").java.srcDirs)
}

artifacts {
    archives(sourcesJar)
}

afterEvaluate {
    publishing {
        publications {
            create<MavenPublication>("release") {
                from(components["release"])
                groupId = libs.versions.app.version.groupId.get()
                artifactId = this@afterEvaluate.name
                version = libs.versions.app.version.versionName.get()
            }
        }
    }
}