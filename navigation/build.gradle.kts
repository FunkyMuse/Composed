plugins {
    alias(libs.plugins.library)
    alias(libs.plugins.kotlinAndroid)
}

dependencies {
    //Compose
    implementation(libs.bundles.compose)
    debugImplementation(libs.bundles.compose.preview)

    //Navigation
    implementation(libs.androidx.navigation.compose)
}