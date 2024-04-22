// Top-level build file where you can add configuration options common to all sub-projects/modules.
@Suppress("DSL_SCOPE_VIOLATION") // TODO: Remove once KTIJ-19369 is fixed
plugins {
    with(libs.plugins) {
        alias(com.android.application) apply false
        alias(org.jetbrains.kotlin.android) apply false
        alias(com.google.dagger.hilt.android) apply false
        alias(org.jetbrains.kotlin.kapt) apply false
    }
}
true // Needed to make the Suppress annotation work for the plugins block