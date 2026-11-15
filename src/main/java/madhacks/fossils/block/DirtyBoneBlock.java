package madhacks.fossils.block;

import madhacks.fossils.Fossils;
import madhacks.fossils.registry.ModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BrushableBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BrushableBlockEntity;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.redstone.Orientation;
import net.minecraft.world.level.storage.loot.LootTable;

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

    private boolean isTouchingWater(Level level, BlockPos pos) {
        for (Direction direction : Direction.values()) {
            BlockPos neighbor = pos.relative(direction);

            if (level.getFluidState(neighbor).is(FluidTags.WATER)) {
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

        if (!level.isClientSide()
                && isTouchingWater(level, pos)
                && !level.getBlockTicks().hasScheduledTick(pos, this)) {

            level.scheduleTick(pos, this, 30);
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

        if (dusted < 3) {
            level.setBlock(
                    pos,
                    state.setValue(BlockStateProperties.DUSTED, dusted + 1),
                    3
            );

            level.scheduleTick(pos, this, 30);
        } else {
            level.setBlock(pos, Blocks.BONE_BLOCK.defaultBlockState(), 3);

            // 25% chance to drop a bone fragment
            if (random.nextFloat() < 0.25F) {
                Block.popResource(
                        level,
                        pos,
                        new ItemStack(ModItems.BONE_FRAGMENT)
                );
            }
        }
    }

    public static final ResourceKey<LootTable> BRUSH_LOOT = ResourceKey.create(
            Registries.LOOT_TABLE, Identifier.fromNamespaceAndPath(Fossils.MOD_ID, "brushing/dirty_bone"));

    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        BrushableBlockEntity be = new BrushableBlockEntity(pos, state);
        be.setLootTable(BRUSH_LOOT, pos.asLong());
        return be;
    }
}