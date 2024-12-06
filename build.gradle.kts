import org.jetbrains.kotlin.gradle.dsl.JvmTarget
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    base
    kotlin("jvm") version "2.0.0" apply false
}

allprojects {
    group = "com.grosslicht"
    version = "1.0-SNAPSHOT"

    repositories {
        mavenCentral()
    }

    tasks.withType(KotlinCompile::class).all {
        compilerOptions {
            jvmTarget.set(JvmTarget.JVM_21)
        }
    }
}

