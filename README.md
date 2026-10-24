# Sponge plugin template

A simple example plugin for Sponge, demonstrating SpongeGradle.

### To get started:

1. Create a new repository from this template
2. Change the project name in `settings.gradle.kts`
3. Move the example plugin to a package in your own namespace
4. Update project group, version, and plugin information in `build.gradle.kts`

### Next steps:

To build a plugin, simply run `./gradlew build`. While working on your plugin, 
run `./gradlew runServer` to get a development server with your plugin installed!

### Gametests

`sponge { gameTests() }` in `build.gradle.kts` runs Minecraft gametests against your plugin on a headless
SpongeVanilla server: `./gradlew test`, or the run icon beside a test in your IDE. Tests live in `src/test` and
never ship in your plugin's jar; see `ExampleGameTests` for the shape of one.

- A test class is annotated `@GameTestGroup`, and each test is an instance method annotated `@GameTest` that takes
  only a `GameTestHelper`. Tests are named `<plugin id>.<group>.<method_name>`.
- A test ends when it calls `succeed()` or its `succeedWhen(...)` check holds; otherwise it fails once `maxTicks`
  run out.
- `GameTestHelper` positions are relative to the test's own space; convert them with `absolutePos` before
  passing them to the Sponge API.
- Tests in a group run at the same time on one server, so keep shared state, like static fields, out of them.

Read more about Sponge plugin development at *(docs not yet written)*

Read more about Gradle from Gradle's [documentation and tutorials](https://docs.gradle.org/current/userguide/getting_started.html)

Feel free to come to the [Sponge discord](https://discord.gg/sponge) for help too!

### Contributing

Is there anything incorrect or confusing about this plugin template? Feel free to
submit a PR with any corrections.

This plugin template is released under the terms of the [Creative Commons CC0 license](TEMPLATE_LICENSE) -- it is available without restriction.
