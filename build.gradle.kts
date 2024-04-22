plugins {
    id("java")
    id("io.qameta.allure") version "2.11.2"


}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation("org.testng:testng:7.10.1")
    testImplementation("junit:junit:4.13.2")
    implementation("com.microsoft.playwright:playwright:1.43.0")
    implementation("org.seleniumhq.selenium:selenium-java:4.19.1")
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
}

tasks.test {
    useJUnitPlatform()
}