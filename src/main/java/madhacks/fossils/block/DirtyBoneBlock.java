
package madhacks.fossils.block;

import net.minecraft.world.level.block.BrushableBlock;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.sounds.SoundEvents;

public class DirtyBoneBlock extends BrushableBlock {

    public DirtyBoneBlock() {
        super(
                Blocks.BONE_BLOCK,
                SoundEvents.BRUSH_SAND,
                SoundEvents.BRUSH_SAND_COMPLETED,
                BlockBehaviour.Properties.of()
                        .strength(2.0F)
                        .sound(Blocks.BONE_BLOCK.defaultBlockState().getSoundType())
        );
    }
}
