plugins {
    alias(libs.plugins.library)
    alias(libs.plugins.kotlinAndroid)
    id(libs.versions.gradlePlugins.maven.publish.get())
}

dependencies {
    //Compose
    implementation(libs.bundles.compose)
    debugImplementation(libs.bundles.compose.preview)

    //Navigation
    implementation(libs.androidx.navigation.compose)
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