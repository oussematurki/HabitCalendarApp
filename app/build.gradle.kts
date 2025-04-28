plugins {
    alias(libs.plugins.android.application)
}

android {
    namespace = "com.example.habitcalendar"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.example.habitcalendar"
        minSdk = 24
        targetSdk = 35
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
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
}

dependencies {
    implementation("androidx.appcompat:appcompat:1.4.1")
    implementation("com.google.android.material:material:1.4.0")
    implementation("androidx.activity:activity:1.3.1")
    implementation("androidx.constraintlayout:constraintlayout:2.1.3")

    // RecyclerView for displaying the habit list
    implementation("androidx.recyclerview:recyclerview:1.2.1")

    // Room database for storing habits
    implementation("androidx.room:room-runtime:2.4.2")
    implementation(libs.navigation.fragment)
    implementation(libs.navigation.ui)
    annotationProcessor("androidx.room:room-compiler:2.4.2")

    // WorkManager for reminders/notifications
    implementation("androidx.work:work-runtime:2.7.1")

    // Testing
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.3")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.4.0")
    implementation("com.google.android.material:material:1.11.0")
}


