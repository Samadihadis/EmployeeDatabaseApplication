import org.jetbrains.kotlin.fir.declarations.builder.buildScript

// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    id("com.android.application") version "8.2.0" apply false
    id("org.jetbrains.kotlin.android") version "1.9.10" apply false
    id("androidx.navigation.safeargs.kotlin") version "2.7.5" apply false
}

buildscript {
    extra.apply {
        set("core_version", "1.12.0")
        set("navigation_version", "2.7.7")
        set("appcompat_version", "1.6.1")
        set("activity_version", "1.8.2")
        set("constraintlayout_version", "2.1.4")
        set("material_version", "1.11.0")
        set("room_version", "2.6.1")
        set("lifecycle_version", "2.7.0")
        set("coroutines_version", "1.8.0")
    }
}