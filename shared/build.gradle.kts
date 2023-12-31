plugins {
    kotlin("multiplatform")
    id("com.android.library")
    id("com.squareup.sqldelight")
//kotlin("com.squareup.sqldelight") version "1.5.0" // Reemplaza con la versión más reciente

    kotlin("plugin.serialization") version "1.6.10"

}

kotlin {
    android {
        compilations.all {
            kotlinOptions {
                jvmTarget = "1.8"
            }
        }
    }

    listOf(
        iosX64(),
        iosArm64(),
        iosSimulatorArm64()
    ).forEach {
        it.binaries.framework {
            baseName = "shared"
        }
    }

    sourceSets {
        val ktorVersion = "2.0.0-beta-1"

        val commonMain by getting {
            dependencies {
                //KTOR
                implementation("io.ktor:ktor-client-core:$ktorVersion")
                implementation("io.ktor:ktor-client-logging:$ktorVersion")
                implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.7.2")


                //SERIALIZATION
                implementation("io.ktor:ktor-client-content-negotiation:$ktorVersion")
                implementation("io.ktor:ktor-serialization-kotlinx-json:$ktorVersion")

                //SQL
                implementation("com.squareup.sqldelight:runtime:1.5.5")

            }
        }
        val commonTest by getting {
            dependencies {
                implementation(kotlin("test"))
            }
        }
        val androidMain by getting {
            dependencies {
                //KTOR
                implementation("io.ktor:ktor-client-okhttp:$ktorVersion")
                implementation("com.squareup.sqldelight:android-driver:1.5.5")

            }
        }
        val androidUnitTest by getting
        val iosX64Main by getting
        val iosArm64Main by getting
        val iosSimulatorArm64Main by getting
        val iosMain by creating {
            dependsOn(commonMain)
            iosX64Main.dependsOn(this)
            iosArm64Main.dependsOn(this)
            iosSimulatorArm64Main.dependsOn(this)
            dependencies {
                //KTOR
                implementation("io.ktor:ktor-client-ios:$ktorVersion")

                implementation("com.squareup.sqldelight:nativedriver:1.5.5")
            }
        }
        val iosX64Test by getting
        val iosArm64Test by getting
        val iosSimulatorArm64Test by getting
        val iosTest by creating {
            dependsOn(commonTest)
            iosX64Test.dependsOn(this)
            iosArm64Test.dependsOn(this)
            iosSimulatorArm64Test.dependsOn(this)
        }
    }
}

android {
    namespace = "com.example.pokedexmultiplataforma"
    compileSdk = 33
    defaultConfig {
        minSdk = 26
    }
}
dependencies {
    implementation("com.google.firebase:firebase-crashlytics-buildtools:2.9.9")
}
/*
sqldelight {
    databases {
        create("pokedexdb") {
            packageName.set("com.example.pokedexmultiplataforma")
        }
    }*/
