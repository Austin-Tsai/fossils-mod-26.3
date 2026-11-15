package madhacks.fossils.registry;

import madhacks.fossils.item.BoneArrowItem;
import net.minecraft.core.Registry;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.entity.EquipmentSlotGroup;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.component.ItemAttributeModifiers;
import net.minecraft.world.item.component.Weapon;

public class ModItems {

    public static final ResourceKey<Item> SHARP_BONE_KEY =
            ResourceKey.create(
                    Registries.ITEM,
                    Identifier.fromNamespaceAndPath("fossils", "sharp_bone")
            );

    public static final Item SHARP_BONE = Registry.register(
            BuiltInRegistries.ITEM,
            SHARP_BONE_KEY,
            new Item(new Item.Properties()
                    .setId(SHARP_BONE_KEY)
                    .durability(60)
                    .component(DataComponents.WEAPON, new Weapon(1))
                    .attributes(ItemAttributeModifiers.builder()
                            .add(Attributes.ATTACK_DAMAGE,
                                    new AttributeModifier(Item.BASE_ATTACK_DAMAGE_ID, 4.0,
                                            AttributeModifier.Operation.ADD_VALUE),
                                    EquipmentSlotGroup.MAINHAND)
                            .add(Attributes.ATTACK_SPEED,
                                    new AttributeModifier(Item.BASE_ATTACK_SPEED_ID, -.6,
                                            AttributeModifier.Operation.ADD_VALUE),
                                    EquipmentSlotGroup.MAINHAND)
                            .build()))
    );

    public static final ResourceKey<Item> BONE_FRAGMENT_KEY = ResourceKey.create(
            Registries.ITEM, Identifier.fromNamespaceAndPath("fossils", "bone_fragment"));
    public static final Item BONE_FRAGMENT = Registry.register(
            BuiltInRegistries.ITEM, BONE_FRAGMENT_KEY,
            new Item(new Item.Properties().setId(BONE_FRAGMENT_KEY)));

    public static final ResourceKey<Item> BONE_ARROW_KEY = ResourceKey.create(
            Registries.ITEM, Identifier.fromNamespaceAndPath("fossils", "bone_arrow"));
    public static final Item BONE_ARROW = Registry.register(
            BuiltInRegistries.ITEM, BONE_ARROW_KEY,
            new BoneArrowItem(new Item.Properties().setId(BONE_ARROW_KEY)));

    public static void initialize() {
        // Touching this class registers the items above.
    }
}