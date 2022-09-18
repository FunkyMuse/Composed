plugins {
    alias(libs.plugins.library)
    alias(libs.plugins.kotlinAndroid)
    id(libs.versions.gradlePlugins.maven.publish.get())
}

android {
    namespace = "com.funkymuse.composed.core"
}

dependencies {
    implementation(libs.bundles.compose)
    debugImplementation(libs.bundles.compose.preview)

    implementation(libs.bundles.lifecycle)
    implementation(libs.androidx.saved.state)
    androidTestImplementation(libs.androidx.androidTestImplementation.test.core)
    androidTestImplementation(libs.androidx.androidTestImplementation.test.rules)
}