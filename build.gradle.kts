plugins {
    kotlin("jvm") version "1.4.20"
}

repositories {
    mavenCentral()
}

dependencies {
    implementation(kotlin("stdlib"))
    testImplementation("org.junit.jupiter:junit-jupiter:5.7.0")
}

tasks.withType<Test> {
    useJUnitPlatform()
}
