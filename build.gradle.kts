import org.jetbrains.compose.compose
import org.jetbrains.compose.desktop.application.dsl.TargetFormat
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("multiplatform")
    kotlin("plugin.serialization") version "1.7.10"
    id("org.jetbrains.compose")
}

group = "com.example"
version = "1.0-SNAPSHOT"

repositories {
    google()
    mavenCentral()
//    maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
}

kotlin {
    jvm {
        compilations.all {
            kotlinOptions.jvmTarget = "11"
        }
        withJava()
    }
    sourceSets {
        val jvmMain by getting {
            dependencies {
                implementation(compose.desktop.currentOs)
                implementation(kotlin("test")) // Core Kotlin test library
                implementation(kotlin("test-junit")) // JUnit support for Kotlin tests
                implementation("io.ktor:ktor-serialization-kotlinx-json-jvm:2.3.12")
                implementation("io.ktor:ktor-server-core-jvm:2.3.12")
                implementation("io.ktor:ktor-server-netty:2.3.12")
                implementation("io.ktor:ktor-server-status-pages-jvm:2.3.12")
                implementation("io.ktor:ktor-server-default-headers-jvm:2.3.12")
                implementation("io.ktor:ktor-client-core:2.3.12")
                implementation("io.ktor:ktor-client-cio:2.3.12")
                implementation("io.ktor:ktor-server-content-negotiation:2.3.12")
                implementation("io.ktor:ktor-serialization-kotlinx-json:2.3.12")
            }
        }
        val jvmTest by getting
    }
}

compose.desktop {
    application {
        mainClass = "MainKt"
        nativeDistributions {
            targetFormats(TargetFormat.Dmg, TargetFormat.Msi, TargetFormat.Deb)
            packageName = "Assignment2"
            packageVersion = "1.0.0"
        }
    }
}