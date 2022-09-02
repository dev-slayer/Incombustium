package net.slayerdev.incombustium.enchantment;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.random.Random;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ItemCurse extends Enchantment {
    public ItemCurse(Rarity weight, EnchantmentTarget type, EquipmentSlot... slotTypes) {
        super(weight, type, slotTypes);
    }

    @Override
    public boolean isTreasure() {
        return true;
    }

    @Override
    public boolean isCursed() {
        return true;
    }

    @Override
    public boolean isAvailableForEnchantedBookOffer() {
        return false;
    }

    @Override
    public boolean isAcceptableItem(ItemStack stack) {
        return true;
    }

    @Override
    public void onUserDamaged(LivingEntity user, Entity attacker, int level) {
        if(user instanceof PlayerEntity) {
            var inventory = ((PlayerEntity) user).getInventory();
            List<Integer> slots = IntStream.range(0, inventory.size()).boxed().collect(Collectors.toList());
            Collections.shuffle(slots);
            for(int i : slots) {
                ItemStack itemStack = inventory.getStack(i);
                int chance = Random.create().nextBetween(1, 10);
                if(EnchantmentHelper.getLevel(RegisterEnchantments.CLUMSY, itemStack) > 0 && chance == 1 && EnchantmentHelper.getLevel(Enchantments.BINDING_CURSE, itemStack) < 1) {
                    ((PlayerEntity) user).dropItem(itemStack, true, false);
                    inventory.setStack(i, ItemStack.EMPTY);
                    break;
                }
            }
        } else if(user instanceof MobEntity) {
            for (EquipmentSlot value : EquipmentSlot.values()) {
                ItemStack stack = user.getEquippedStack(value);
                int chance = Random.create().nextBetween(1, 10);
                if(EnchantmentHelper.getLevel(RegisterEnchantments.CLUMSY, stack) > 0 && chance == 1 && EnchantmentHelper.getLevel(Enchantments.BINDING_CURSE, stack) < 1) {
                    user.dropStack(stack);
                    user.equipStack(value, ItemStack.EMPTY);
                }
            }
        }
    }
}