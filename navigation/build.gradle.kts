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

afterEvaluate {
    publishing {
        publications {
            register<MavenPublication>("release") {
                from(components.getByName("release"))
                groupId = libs.versions.app.version.groupId.get()
                artifactId = this@afterEvaluate.name
                version = libs.versions.app.version.versionName.get()
            }

            register<MavenPublication>("debug") {
                from(components.getByName("debug"))
                groupId = libs.versions.app.version.groupId.get()
                artifactId = this@afterEvaluate.name
                version = libs.versions.app.version.versionName.get()
            }
        }
    }
}