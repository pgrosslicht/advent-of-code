import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    base
    kotlin("jvm") version "1.6.0" apply false
}

allprojects {
    group = "com.grosslicht"
    version = "1.0-SNAPSHOT"

    repositories {
        mavenCentral()
    }

    tasks.withType(KotlinCompile::class).all {
        kotlinOptions {
            jvmTarget = "1.8"
        }
    }
}

