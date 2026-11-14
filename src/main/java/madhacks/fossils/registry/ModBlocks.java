
package madhacks.fossils.registry;

import madhacks.fossils.block.DirtyBoneBlock;
import madhacks.fossils.mixin.BlockEntityTypeAccessor;

import java.util.HashSet;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntityTypes;

public class ModBlocks {

    public static final Block DIRTY_BONE_BLOCK = Registry.register(
            BuiltInRegistries.BLOCK,
            Identifier.fromNamespaceAndPath("fossils", "dirty_bone_block"),
            new DirtyBoneBlock()
    );

    public static final BlockItem DIRTY_BONE_BLOCK_ITEM = Registry.register(
            BuiltInRegistries.ITEM,
            Identifier.fromNamespaceAndPath("fossils", "dirty_bone_block"),
            new BlockItem(DIRTY_BONE_BLOCK, new Item.Properties())
    );

    public static void initialize() {
        BlockEntityTypeAccessor accessor =
                (BlockEntityTypeAccessor) (Object) BlockEntityTypes.BRUSHABLE_BLOCK;

        HashSet<Block> blocks =
                new HashSet<>(accessor.fossils$getValidBlocks());

        blocks.add(DIRTY_BONE_BLOCK);

        accessor.fossils$setValidBlocks(blocks);
    }
}
