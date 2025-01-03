package net.valoris.tutorialmod.item;

import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.FoodComponent;
import net.minecraft.item.FoodComponents;

public class ModFoodComponents {
    public static final FoodComponent Tomato = new FoodComponent.Builder().hunger(3).saturationModifier(.25f)
            .statusEffect(new StatusEffectInstance(StatusEffects.LUCK, 200), 0.25f).build();
}
