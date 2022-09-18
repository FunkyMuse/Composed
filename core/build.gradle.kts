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