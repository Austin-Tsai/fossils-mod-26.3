package madhacks.fossils.item;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.arrow.AbstractArrow;
import net.minecraft.world.item.ArrowItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

public class BoneArrowItem extends ArrowItem {
    public BoneArrowItem(Item.Properties props) {
        super(props);
    }

    @Override
    public AbstractArrow createArrow(Level level, ItemStack ammo,
                                     LivingEntity shooter, @Nullable ItemStack weapon) {
        AbstractArrow arrow = super.createArrow(level, ammo, shooter, weapon);
        arrow.setBaseDamage(2.5);
        return arrow;
    }
}