plugins {
    java
    checkstyle
    application
    jacoco
    id("com.adarshr.test-logger") version "4.0.0"
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
    implementation("com.fasterxml.jackson.dataformat:jackson-dataformat-yaml:2.10.4")
    implementation("commons-io:commons-io:2.7")
    implementation("org.apache.commons:commons-lang3:3.16.0")
}

tasks.test {
    useJUnitPlatform()
    finalizedBy(tasks.jacocoTestReport)
}

tasks.jacocoTestReport {
    reports {
        xml.required.set(true)
    }
}
