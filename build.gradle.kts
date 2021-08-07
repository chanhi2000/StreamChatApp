// Top-level build file where you can add configuration options common to all sub-projects/modules.
buildscript {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
        maven { url = uri("https://www.jetbrains.com/intellij-repository/releases")  }
        maven { url = uri("https://jetbrains.bintray.com/intellij-third-party-dependencies")  }
    }

    dependencies {
        classpath(Plugin.android)
        classpath(Plugin.kotlin)
        classpath(Plugin.dagger)
        classpath(Plugin.androidxNav)
    }
}

allprojects {
    repositories {
        google()
        mavenCentral()
        maven { url = uri("https://devrepo.kakao.com/nexus/content/groups/public/") }
        maven { url = uri("https://jitpack.io") }
    }
}

tasks.register("clean",Delete::class) {
    delete = setOf(rootProject.buildDir)
}