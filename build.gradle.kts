import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
import org.jetbrains.kotlin.com.google.common.collect.ImmutableMap


plugins {
    id("org.springframework.boot") version "3.1.0"
    id("io.spring.dependency-management") version "1.1.0"
    kotlin("jvm") version "1.8.21"
    kotlin("plugin.spring") version "1.8.21"
    id("com.palantir.docker") version "0.35.0"
    id("com.palantir.docker-run") version "0.35.0"
    id("com.palantir.docker-compose") version "0.35.0"
}

group = "com.github.mikesmithgh"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_17

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-data-jdbc")
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
    implementation("org.flywaydb:flyway-core")
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("org.postgresql:postgresql")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testImplementation("com.ninja-squad:springmockk:4.0.2")
    testImplementation("io.mockk:mockk:1.8.8")
}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        freeCompilerArgs = listOf("-Xjsr305=strict")
        jvmTarget = "17"
    }
}

tasks.withType<Test> {
    useJUnitPlatform()
}

apply(plugin = "com.palantir.docker")

val dockerImageName = "com.github.mikesmithgh/za"

dockerRun {
    name = "za"
    image = "com.github.mikesmithgh/za:".plus(version)
    ports("8080:8080")
}

docker {
    name = "com.github.mikesmithgh/za:".plus(version)
    tag("name", "za")
    buildArgs(ImmutableMap.of("name", "za"))
    copySpec.from("build").into("build")
    setDockerfile(file("Dockerfile"))
}

