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
        getByName("release") {
            isMinifyEnabled = false
            isDebuggable = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
            buildConfigField("String" , "BASE_URL" ,"\"https://newastro.vercel.app/\"")

            resValue("string" , "jorzus" , "HoroscoApp")
        }


        getByName("debug"){
            isDebuggable = true
            resValue("string" , "jorzus" , "[DEBUG]-HoroscoApp")
            buildConfigField("String" , "BASE_URL" ,"\"https://newastro-debug.vercel.app/\"")
        }



    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }

    buildFeatures {
        viewBinding = true
        buildConfig = true
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



    //retrofit para el consumo de apis y converter-gson para transformar mi data en un json
    implementation("com.squareup.retrofit2:retrofit:2.9.0")
    implementation("com.squareup.retrofit2:converter-gson:2.9.0")



    //loggin interceptor -->
    implementation("com.squareup.okhttp3:logging-interceptor:4.3.1")




    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}