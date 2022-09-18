plugins {
    alias(libs.plugins.android)
    alias(libs.plugins.kotlinAndroid)
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
    namespace = "com.funkymuse.composedlib"
}

dependencies {
    implementation(projects.core)
    implementation(projects.navigation)

    //core
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appCompat)

    //material
    implementation(libs.material)

    //Compose
    implementation(libs.bundles.compose)
    debugImplementation(libs.bundles.compose.preview)

    //lifecycle
    implementation(libs.bundles.lifecycle)

    //Navigation
    implementation(libs.androidx.navigation.compose)
}