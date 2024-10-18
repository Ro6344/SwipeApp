import org.apache.tools.ant.util.JavaEnvUtils.VERSION_1_8

plugins {
    alias(libs.plugins.androidApplication)
}

android {
    namespace = "com.example.swipevideo"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.swipevideo"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    compileOptions {
       // sourceCompatibility = VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
}

dependencies {

    implementation(libs.appcompat)
    implementation(libs.material)
    implementation(libs.activity)
    implementation(libs.constraintlayout)
   // implementation(fileTree(mapOf("dir" to "C:\\Users\\Rocio\\AppData\\Local\\Android\\Sdk\\platforms\\android-34", "include" to listOf("*.aar", "*.jar"), "exclude" to listOf())))
    testImplementation(libs.junit)
    androidTestImplementation(libs.ext.junit)
    androidTestImplementation(libs.espresso.core)
}