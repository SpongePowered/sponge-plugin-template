import org.spongepowered.gradle.plugin.config.PluginLoaders
import org.spongepowered.plugin.metadata.model.PluginDependency

plugins {
    val spongeGradleVersion = "2.1.1"

    `java-library`
    id("org.spongepowered.gradle.plugin") version spongeGradleVersion
    id("org.spongepowered.gradle.ore") version spongeGradleVersion // for Ore publishing
}

group = "org.spongepowered"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

sponge {
    apiVersion("8.1.0")
    license("CHANGEME")
    loader {
        name(PluginLoaders.JAVA_PLAIN)
        version("1.0")
    }
    plugin("example") {
        displayName("Example")
        entrypoint("org.spongepowered.example.Example")
        description("Just testing things...")
        links {
            homepage("https://spongepowered.org")
            source("https://spongepowered.org/source")
            issues("https://spongepowered.org/issues")
        }
        contributor("Spongie") {
            description("Lead Developer")
        }
        dependency("spongeapi") {
            loadOrder(PluginDependency.LoadOrder.AFTER)
            optional(false)
        }
    }
}

val javaTarget = 8 // Sponge targets a minimum of Java 8
java {
    sourceCompatibility = JavaVersion.toVersion(javaTarget)
    targetCompatibility = JavaVersion.toVersion(javaTarget)
}

tasks.withType(JavaCompile::class).configureEach {
    options.apply {
        encoding = "utf-8" // Consistent source file encoding
        if (JavaVersion.current().isJava10Compatible) {
            release.set(javaTarget)
        }
    }
}

// Make sure all tasks which produce archives (jar, sources jar, javadoc jar, etc) produce more consistent output
tasks.withType(AbstractArchiveTask::class).configureEach {
    isReproducibleFileOrder = true
    isPreserveFileTimestamps = false
}

// Optional: configure publication to Ore
// Publish using the publishToOre task
// An API token is needed for this, by default read from the ORE_TOKEN environment variable
oreDeployment {
    // The default publication here is automatically configured by SpongeGradle
    // using the first-created plugin's ID as the project ID
    // A version body is optional, to provide additional information about the release
    /*
    defaultPublication {
        // Read the version body from the file whose path is provided to the changelog gradle property
        versionBody.set(providers.gradleProperty("changelog").map { file(it).readText(Charsets.UTF_8) }.orElse(""))
    }*/
}
