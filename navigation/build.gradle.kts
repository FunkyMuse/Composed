plugins {
    alias(libs.plugins.library)
    alias(libs.plugins.kotlinAndroid)
}

dependencies {
    //Compose
    implementation(libs.bundles.compose)
    debugImplementation(libs.bundles.compose.preview)

    //core
    api(projects.core)

    //Navigation
    api(libs.androidx.navigation.compose)
}