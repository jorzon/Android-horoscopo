plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    id("kotlin-kapt")
    id("com.google.dagger.hilt.android")


    id("androidx.navigation.safeargs.kotlin")
}

android {

    //el compileSdk y el targetSdk siempre deben tener la misma version
    namespace = "com.jorzus.horoscoapp"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.jorzus.horoscoapp"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }

    viewBinding {
        enable = true
    }

    kotlin{
        jvmToolchain(8)
    }

}

dependencies {

    var navVersion = "2.7.1"

    //NavComponents --> deben tener la misma version
    implementation("androidx.navigation:navigation-fragment-ktx:$navVersion")
    implementation("androidx.navigation:navigation-ui-ktx:$navVersion")



    //DAGGER HILT --> INYECTOR DE DEPENDENCIAS
    implementation("com.google.dagger:hilt-android:2.48") //crea clase por detras
    kapt("com.google.dagger:hilt-compiler:2.48") //permite autogenerar codigo

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}