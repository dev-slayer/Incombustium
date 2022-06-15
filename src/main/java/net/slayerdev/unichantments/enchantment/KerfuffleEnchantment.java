package net.slayerdev.unichantments.enchantment;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.*;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.slayerdev.unichantments.effect.ModEffects;

public class KerfuffleEnchantment extends Enchantment {
    public KerfuffleEnchantment(Rarity weight, EnchantmentTarget type, EquipmentSlot... slotTypes) {
        super(weight, type, slotTypes);
    }

    @Override
    public void onTargetDamaged(LivingEntity user, Entity target, int level) {
        if(!user.world.isClient()) {
            int chance_rng = (int)Math.floor(Math.random()*(10-1+1)+1);
            if(level == 1 && chance_rng == level) {
                ((LivingEntity) target).addStatusEffect(new StatusEffectInstance(ModEffects.RANDOM, 1, 0));
            }
            if(level >= 2 && chance_rng >= 1 && chance_rng <= level) {
                ((LivingEntity) target).addStatusEffect(new StatusEffectInstance(ModEffects.RANDOM, 1, 0));
            }
        }
        super.onTargetDamaged(user, target, level);
    }

    @Override
    public int getMaxLevel() {
        return 2;
    }

    @Override
    public boolean isTreasure() {
        return true;
    }

    @Override
    public boolean isAvailableForEnchantedBookOffer() {
        return false;
    }

    @Override
    public boolean isAvailableForRandomSelection() {
        return false;
    }
}