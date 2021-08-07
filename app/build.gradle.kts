plugins {
    id("com.android.application")
    id("kotlin-android")
    id("kotlin-kapt")
    id("dagger.hilt.android.plugin")
    id("androidx.navigation.safeargs.kotlin")
}

android {
    compileSdkVersion(Versions.compileSdk)
    buildToolsVersion(Versions.buildTools)

    defaultConfig {
        applicationId = "com.plcoding.streamchatapp"
        minSdkVersion(21)
        targetSdkVersion(30)
        versionCode = 1
        versionName = "1.0"
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }
    kapt {
        javacOptions {
            option("-Adagger.hilt.android.internal.disableAndroidSuperclassValidation=true")
        }
    }

    buildFeatures {
        viewBinding = true
    }

    buildTypes {
        named("release").configure {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "${JavaVersion.VERSION_11}"
    }

    sourceSets {
        getByName("main") {
            java.srcDirs("src/main/java", "src/main/kotlin")
            manifest.srcFile("src/main/AndroidManifest.xml")
            res.srcDirs("src/main/res")
        }
    }
}

dependencies {
    implementation(Dep.kotlin_stdlib)
    implementation(Dep.androidx)
    implementation(Dep.material)

    implementation(Dep.androidxKtx)
    implementation(Dep.coroutine)
    implementation(Dep.androidxLifecycle)
    implementation(Dep.androidxNav)

    implementation(Dep.coil)        // 이미지 로딩
    implementation("io.getstream:stream-chat-android-ui-components:4.12.1")

    //Dagger - Hilt
    implementation(Dep.dagger)
    kapt(Dep.daggerCompiler)
    implementation(Dep.hilt)
    kapt(Dep.hiltCompiler)

    testImplementation(Dep.junit)
    androidTestImplementation(Dep.androidxTest)
}