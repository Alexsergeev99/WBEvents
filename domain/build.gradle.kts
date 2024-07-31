plugins {
    id("java-library")
    alias(libs.plugins.jetbrains.kotlin.jvm)
}

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}

tasks.test {
    useJUnitPlatform()
}

dependencies {

    implementation(platform(libs.koin.bom))
    testImplementation(libs.junit)
    implementation(libs.koin.core)
    testImplementation(libs.koin.test)
    implementation(libs.kotlinx.coroutines.core)
    testImplementation(libs.kotlinx.coroutines.test.v190rc)
    testImplementation(libs.junit.jupiter)

}