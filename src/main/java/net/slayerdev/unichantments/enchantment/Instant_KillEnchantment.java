package net.slayerdev.unichantments.enchantment;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.slayerdev.unichantments.effect.ModEffects;

public class Instant_KillEnchantment extends Enchantment {
    protected Instant_KillEnchantment(Rarity weight, EnchantmentTarget type, EquipmentSlot... slotTypes) {
        super(weight, type, slotTypes);
    }

    @Override
    public void onTargetDamaged(LivingEntity user, Entity target, int level) {
        if(!user.world.isClient() && target instanceof LivingEntity) {
            ((LivingEntity) target).addStatusEffect(new StatusEffectInstance(ModEffects.EVOCATION, 10, 0, false, false));
        }

        super.onTargetDamaged(user, target, level);
    }

    @Override
    public int getMaxLevel() {
        return 1;
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
