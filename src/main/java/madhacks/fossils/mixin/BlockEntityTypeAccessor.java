
package madhacks.fossils.mixin;

import java.util.Set;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntityType;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(BlockEntityType.class)
public interface BlockEntityTypeAccessor {

    @Accessor("validBlocks")
    Set<Block> fossils$getValidBlocks();

    @Mutable
    @Accessor("validBlocks")
    void fossils$setValidBlocks(Set<Block> blocks);
}
