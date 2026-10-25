package org.spongepowered.example;

import net.minecraft.core.BlockPos;
import net.minecraft.gametest.framework.GameTestHelper;
import net.minecraft.world.level.block.Blocks;
import org.spongepowered.api.Sponge;
import org.spongepowered.common.test.gametest.GameTest;
import org.spongepowered.common.test.gametest.GameTestGroup;

/**
 * Gametests run on a headless SpongeVanilla server with this plugin loaded, through {@code ./gradlew test} or the run
 * icon beside a test. Each is named {@code example.<group>.<method_name>}, here {@code example.basics.*}.
 */
@GameTestGroup("basics")
public final class ExampleGameTests {

    // The plugin registers /greet during RegisterCommandEvent, so it is there once the server runs the test
    @GameTest
    void greetCommandIsRegistered(final GameTestHelper helper) {
        helper.succeedWhen(() -> helper.assertTrue(
            Sponge.server().commandManager().knownAliases().contains("greet"), "the greet command is registered"));
    }

    // Positions are relative to the test's own 3x3x3 space. A test passes once it calls succeed() or its
    // succeedWhen(...) check holds, and fails if neither happens within maxTicks (20 by default).
    @GameTest
    void placedBlockIsThere(final GameTestHelper helper) {
        final BlockPos pos = new BlockPos(1, 1, 1);
        helper.setBlock(pos, Blocks.STONE);
        helper.succeedWhen(() -> helper.assertBlockPresent(Blocks.STONE, pos));
    }
}
