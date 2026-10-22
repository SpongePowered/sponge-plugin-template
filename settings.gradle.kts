pluginManagement {
    repositories {
        gradlePluginPortal()
        // VanillaGradle's own dependencies are published here
        maven("https://repo.spongepowered.org/repository/maven-public/") {
            name = "sponge"
        }
    }
}

rootProject.name = "sponge-plugin-template"
