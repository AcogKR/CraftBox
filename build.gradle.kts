plugins {
    kotlin("jvm") version "1.8.0"
    id("kr.entree.spigradle") version "2.4.3"
    id("com.github.johnrengelman.shadow") version "7.1.2"
}

group = "dev.acog"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
    maven("https://papermc.io/repo/repository/maven-public/")
}

dependencies {
    compileOnly("io.papermc.paper:paper-api:1.19.3-R0.1-SNAPSHOT")
    implementation("io.typecraft:bukkit-view-core:5.1.2")
    implementation("io.heartpattern.springfox:springfox-starter:0.1.15")

    implementation("org.springframework.boot:spring-boot-starter-data-jpa:3.0.5")
    runtimeOnly("com.h2database:h2:2.0.202")
}

tasks {
    compileKotlin.get().kotlinOptions.jvmTarget = "17"
    assemble.get().dependsOn(shadowJar)
}

kotlin {
    jvmToolchain(17)
}

spigot {
    main = "dev.acog.craftbox.CraftBox"
}