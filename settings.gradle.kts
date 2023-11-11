pluginManagement {
    repositories {
        google()
        gradlePluginPortal()
        mavenCentral()
    }
}

dependencyResolutionManagement {
    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
        maven(url = "https://dl.bintray.com/square/sqldelight")
    }
}

rootProject.name = "PokedexMultiplataforma"
include(":androidApp")
include(":shared")