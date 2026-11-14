
package madhacks.fossils.block;

import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceKey;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.BrushableBlock;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.entity.BrushableBlockEntity;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;

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

    @Override
    public void tick(BlockState state, ServerLevel level, BlockPos pos, RandomSource random) {
        if (level.getBlockEntity(pos) instanceof BrushableBlockEntity be) {
            be.checkReset(level);
        }
    }
}
