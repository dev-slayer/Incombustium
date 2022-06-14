package net.slayerdev.unichantments.enchantment;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.*;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;

public class ConductorEnchantment extends Enchantment {
    public ConductorEnchantment(Rarity weight, EnchantmentTarget type, EquipmentSlot... slotTypes) {
        super(weight, type, slotTypes);
    }

    @Override
    public void onTargetDamaged(LivingEntity user, Entity target, int level) {
        if(!user.world.isClient()) {
            ServerWorld world = (ServerWorld)user.world;
            BlockPos position = target.getBlockPos();

            if(level == 1) {
                EntityType.LIGHTNING_BOLT.spawn(world, null, null, null, position,
                        SpawnReason.TRIGGERED, true, true);
            }
        }

        super.onTargetDamaged(user, target, level);
    }
    public void onUserDamaged(LivingEntity user, Entity attacker, int level) {
        int chance_rng = (int)Math.floor(Math.random()*(60-1+1)+1);
        if(level == 1 && chance_rng == level) {
            ServerWorld world = (ServerWorld)attacker.world;
            BlockPos position = attacker.getBlockPos();EntityType.LIGHTNING_BOLT.spawn(world, null, null, null, position, SpawnReason.TRIGGERED, true, true);
        }
        if(level == 2 && chance_rng >= 1 && chance_rng <= level) {
            ServerWorld world = (ServerWorld)attacker.world;
            BlockPos position = attacker.getBlockPos();EntityType.LIGHTNING_BOLT.spawn(world, null, null, null, position, SpawnReason.TRIGGERED, true, true);
        }
        if(level == 3 && chance_rng >= 1 && chance_rng <= level) {
            ServerWorld world = (ServerWorld)attacker.world;
            BlockPos position = attacker.getBlockPos();EntityType.LIGHTNING_BOLT.spawn(world, null, null, null, position, SpawnReason.TRIGGERED, true, true);
        }
        super.onUserDamaged(user, attacker, level);
    }

    @Override
    public int getMaxLevel() {
        return 3;
    }
}