import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    base
    kotlin("jvm") version "1.6.0" apply false
}

allprojects {
    group = "com.grosslicht"
    version = "1.0-SNAPSHOT"

    repositories {
        jcenter()
        mavenCentral()
    }

    tasks.withType(KotlinCompile::class).all {
        kotlinOptions {
            jvmTarget = "1.8"
        }
    }
}

dependencies {
    // Make the root project archives configuration depend on every subproject
    subprojects.forEach {
        archives(it)
    }
}
