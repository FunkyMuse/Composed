pluginManagement {
    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
    }

    resolutionStrategy {
        eachPlugin {
            // Some plugins are not on the Gradle Plugins portal and require trickery to resolve
            // since Maven repos know nothing of plugin IDs.
            when (requested.id.id) {
                "maven.publish" -> {
                    useModule("com.github.dcendents:android-maven-gradle-plugin:${requested.version}")
                }
            }
        }
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
        maven { setUrl("https://jitpack.io") }
    }
}
enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")
rootProject.name = "ComposedLib"
include(
    ":app",
    ":core",
    ":navigation",
)
include(":placeholder")
include(":placeholder-m3")
