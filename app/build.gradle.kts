plugins {
    id("java")
    application
}

application {
    mainClass = "hexlet.code.App"
}

group = "hexlet.code"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.11.0-M1"))
    testImplementation("org.junit.jupiter:junit-jupiter:5.11.0-M1")
    implementation("info.picocli:picocli:4.7.5")
    implementation("info.picocli:picocli-codegen:4.7.5")
    implementation("com.fasterxml.jackson.core:jackson-databind:2.16.1")
}

tasks.test {
    useJUnitPlatform()
}
