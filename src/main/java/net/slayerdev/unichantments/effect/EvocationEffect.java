package net.slayerdev.unichantments.effect;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.attribute.AttributeContainer;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;


public class EvocationEffect extends StatusEffect {
    public EvocationEffect(StatusEffectCategory statusEffectCategory, int color) {
        super(statusEffectCategory, color);
    }

    @Override
    public void onRemoved(LivingEntity user, AttributeContainer attributes, int amplifier) {
        if(!user.world.isClient()) {
            ServerWorld world = (ServerWorld)user.world;
            BlockPos position = user.getBlockPos();EntityType.EVOKER_FANGS.spawn(world, null, null, null, position, SpawnReason.TRIGGERED, true, true);
        }
    }
}