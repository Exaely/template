@Suppress("DSL_SCOPE_VIOLATION") // TODO: Remove once KTIJ-19369 is fixed
plugins {
    with(libs.plugins) {
        alias(com.android.application)
        alias(org.jetbrains.kotlin.android)
        alias(com.google.dagger.hilt.android)
        alias(org.jetbrains.dokka)
        alias(io.gitlab.arturbosch.detekt)
        alias(org.jetbrains.kotlin.kapt)
    }
}

android {
    namespace = "tech.exaely.template"
    compileSdk = 34

    defaultConfig {
        applicationId = "tech.exaely.template"
        minSdk = 25
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
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
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.4.3"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {

    with(libs) {
        dokkaPlugin(dokka)
        detektPlugins(detekt.rules.compose)

        implementAll(
            accompanist.permissions,
            activity.compose,
            coil.compose,
            coil.svg,
            compose.material3,
            core.ktx,
            datastore,
            hilt.android,
            hilt.navigation.compose,
            kotlinx.collections.immutable,
            lifecycle.runtime.ktx,
            moshi,
            navigation.compose,
            platform(compose.bom),
            retrofit,
            room,
            room.ktx,
            ui,
            ui.graphics,
            ui.tooling.preview,
        )

        kaptAll(
            hilt.compiler,
            room.compiler,
        )

        androidTestImplementation(androidx.test.ext.junit)
        androidTestImplementation(espresso.core)
        androidTestImplementation(platform(compose.bom))
        androidTestImplementation(ui.test.junit4)

        debugImplementation(ui.test.manifest)
        debugImplementation(ui.tooling)

        testImplementation(junit)
        testImplementation(kotlinx.coroutines.test)
        testImplementation(mockk.agent)
        testImplementation(mockk.android)
    }
}

fun DependencyHandler.implementAll(vararg dependencies: Any) {
    for (dependency in dependencies) {
        implementation(dependency)
    }
}

fun DependencyHandler.kaptAll(vararg dependencies: Any) {
    for (dependency in dependencies) {
        implementation(dependency)
    }
}