
plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id ("androidx.navigation.safeargs")
    id ("kotlin-kapt")
}

android {
    namespace = "com.samadihadis.employeedatabaseapplication"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.samadihadis.employeedatabaseapplication"
        minSdk = 21
        targetSdk = 34
        versionCode = 1
        versionName = "1.0.0"

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
    buildFeatures{
        viewBinding = true
    }
}

dependencies {


    val kotlinVersion = rootProject.extra["kotlin_version"]
    val coreVersion = rootProject.extra["core_version"]
    val navigationVersion = rootProject.extra["navigation_version"]
    val activityVersion = rootProject.extra["activity_version"]
    val appcompatVersion = rootProject.extra["appcompat_version"]
    val constraintlayoutVersion = rootProject.extra["constraintlayout_version"]
    val coroutinesVersion = rootProject.extra["coroutines_version"]
    val lifecycleVersion = rootProject.extra["lifecycle_version"]
    val materialVersion = rootProject.extra["material_version"]
    val roomVersion = rootProject.extra["room_version"]


    // Main
    implementation ("androidx.appcompat:appcompat:$appcompatVersion")
    implementation ("androidx.activity:activity-ktx:$activityVersion")
    implementation("androidx.core:core-ktx:$coreVersion")


    // UI
    implementation ("androidx.constraintlayout:constraintlayout:$constraintlayoutVersion")
    implementation ("com.google.android.material:material:$materialVersion")


    // Navigation
    implementation("androidx.navigation:navigation-fragment-ktx:$navigationVersion")
    implementation("androidx.navigation:navigation-ui-ktx:$navigationVersion")


    // Room components
    implementation ("androidx.room:room-ktx:$roomVersion")
    kapt ("androidx.room:room-compiler:$roomVersion")


    // Lifecycle components
    implementation ("androidx.lifecycle:lifecycle-viewmodel-ktx:$lifecycleVersion")
    implementation ("androidx.lifecycle:lifecycle-livedata-ktx:$lifecycleVersion")
    implementation ("androidx.lifecycle:lifecycle-common-java8:$lifecycleVersion")

    
    // Kotlin components
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk7:$kotlinVersion")
    api ("org.jetbrains.kotlinx:kotlinx-coroutines-core:$coroutinesVersion")
    api ("org.jetbrains.kotlinx:kotlinx-coroutines-android:$coroutinesVersion")


    // Test
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
}