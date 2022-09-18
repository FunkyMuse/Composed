plugins {
    alias(libs.plugins.library)
    alias(libs.plugins.kotlinAndroid)
    id(libs.versions.gradlePlugins.maven.publish.get())
}

android {
    namespace = "com.funkymuse.composed.navigation"
}

dependencies {
    //Compose
    implementation(libs.bundles.compose)
    debugImplementation(libs.bundles.compose.preview)

    //Navigation
    implementation(libs.androidx.navigation.compose)
}