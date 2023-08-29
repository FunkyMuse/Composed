plugins {
    alias(libs.plugins.library)
    alias(libs.plugins.kotlinAndroid)
}

dependencies {
    //Compose
    implementation(libs.bundles.compose)
    implementation(libs.compose.material3)
    debugImplementation(libs.bundles.compose.preview)

    api(projects.placeholder)
}