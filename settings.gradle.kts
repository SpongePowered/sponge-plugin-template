pluginManagement {
    repositories {
        gradlePluginPortal()
        // Temporary until initial release
        maven("https://repo.spongepowered.org/repository/maven-public/") {
            name = "sponge"
        }
    }
}

rootProject.name = "sponge-plugin-template"