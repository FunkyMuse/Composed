plugins {
    alias(libs.plugins.android)
    alias(libs.plugins.kotlinAndroid)
    alias(libs.plugins.ksp)
    alias(libs.plugins.hilt)
}

android {
    buildTypes {
        debug {
            isCrunchPngs = false
            isMinifyEnabled = false
            isShrinkResources = false
            applicationIdSuffix = ".debug"
        }
        release {
            isMinifyEnabled = true
            isShrinkResources = true
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
}

hilt {
    enableAggregatingTask = true
}

dependencies {
    implementation(projects.core)
    implementation(projects.navigation)

    implementation(libs.bundles.hilt)
    ksp(libs.bundles.hilt.kapt)

    //core
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appCompat)

    //Compose
    implementation(libs.bundles.compose)
    implementation(libs.compose.material3)
    implementation(libs.bundles.accompanist)
    debugImplementation(libs.bundles.compose.preview)

    //lifecycle
    implementation(libs.bundles.lifecycle)

    //Navigation
    implementation(libs.androidx.navigation.compose)
}