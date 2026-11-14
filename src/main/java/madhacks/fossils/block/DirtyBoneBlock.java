
package madhacks.fossils.block;

import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.block.BrushableBlock;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.level.block.Block;

public class DirtyBoneBlock extends BrushableBlock {

    public DirtyBoneBlock(ResourceKey<Block> id) {
        super(
                Blocks.BONE_BLOCK,
                SoundEvents.BRUSH_SAND,
                SoundEvents.BRUSH_SAND_COMPLETED,
                Properties.of()
                        .setId(id)
                        .strength(2.0F)
                        .sound(Blocks.BONE_BLOCK.defaultBlockState().getSoundType())
        );
    }
}
