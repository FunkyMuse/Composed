plugins {
    alias(libs.plugins.library)
    alias(libs.plugins.kotlinAndroid)
    alias(libs.plugins.mavenPublish)
}

dependencies {
    //Compose
    implementation(libs.bundles.compose)
    debugImplementation(libs.bundles.compose.preview)

    //Navigation
    implementation(libs.androidx.navigation.compose)
}