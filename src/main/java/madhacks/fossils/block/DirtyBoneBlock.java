package madhacks.fossils.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.resources.ResourceKey;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BrushableBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.redstone.Orientation;

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
    protected void createBlockStateDefinition(
            net.minecraft.world.level.block.state.StateDefinition.Builder<Block, BlockState> builder
    ) {
        super.createBlockStateDefinition(builder);
        builder.add(BlockStateProperties.DUSTED);
    }

    private boolean isTouchingWater(Level level, BlockPos pos) {
        for (Direction direction : Direction.values()) {
            BlockPos neighbor = pos.relative(direction);

            if (level.getFluidState(neighbor).is(Fluids.WATER)) {
                return true;
            }
        }

        return false;
    }

    @Override
    protected void neighborChanged(
            BlockState state,
            Level level,
            BlockPos pos,
            Block block,
            Orientation orientation,
            boolean movedByPiston
    ) {
        super.neighborChanged(state, level, pos, block, orientation, movedByPiston);

        if (!level.isClientSide() && isTouchingWater(level, pos)) {
            level.scheduleTick(pos, this, 40);
        }
    }

    @Override
    public void tick(
            BlockState state,
            ServerLevel level,
            BlockPos pos,
            RandomSource random
    ) {
        if (!isTouchingWater(level, pos)) {
            return;
        }

        int dusted = state.getValue(BlockStateProperties.DUSTED);

        if (dusted > 0) {
            level.setBlock(
                    pos,
                    state.setValue(BlockStateProperties.DUSTED, dusted - 1),
                    3
            );

            level.scheduleTick(pos, this, 40);
        } else {
            level.setBlock(pos, Blocks.BONE_BLOCK.defaultBlockState(), 3);
        }
    }
}