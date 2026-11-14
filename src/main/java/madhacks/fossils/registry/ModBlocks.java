
package madhacks.fossils.registry;

import madhacks.fossils.block.DirtyBoneBlock;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;
import net.minecraft.world.level.block.Block;
import net.minecraft.core.Registry;


public class ModBlocks {

    public static final Block DIRTY_BONE_BLOCK = Registry.register(
            BuiltInRegistries.BLOCK,
            Identifier.fromNamespaceAndPath("fossils", "dirty_bone_block"),
            new DirtyBoneBlock()
    );

    public static void initialize() {
        // Triggers block registration
    }
}
