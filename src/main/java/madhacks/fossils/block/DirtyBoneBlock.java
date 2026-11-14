package madhacks.fossils.block;

import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.block.BrushableBlock;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.sounds.SoundEvents;

public class DirtyBoneBlock extends BrushableBlock {

    private static ResourceKey<net.minecraft.world.level.block.Block> createKey() {
        return ResourceKey.create(
                Registries.BLOCK,
                Identifier.fromNamespaceAndPath("fossils", "dirty_bone_block")
        );
    }

    public DirtyBoneBlock() {
        super(
                Blocks.BONE_BLOCK,
                SoundEvents.BRUSH_SAND,
                SoundEvents.BRUSH_SAND_COMPLETED,
                BlockBehaviour.Properties.of()
                        .setId(createKey())
                        .strength(2.0F)
                        .sound(Blocks.BONE_BLOCK.defaultBlockState().getSoundType())
        );
    }
}