package net.slayerdev.unichantments.effect;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.AttributeContainer;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;


public class RandomEffect extends StatusEffect {

    public RandomEffect() {
        super(StatusEffectCategory.HARMFUL, 0x95B282);
    }

    @Override
    public void onRemoved(LivingEntity user, AttributeContainer attributes, int amplifier) {
        if(!user.world.isClient()) {
            int random = (int)Math.floor(Math.random()*(33-1+1)+1);
            switch(random) {
                case 1: ((LivingEntity) user).addStatusEffect(new StatusEffectInstance(StatusEffects.SPEED, 100, 0)); break;
                case 2: ((LivingEntity) user).addStatusEffect(new StatusEffectInstance(StatusEffects.SLOWNESS, 100, 0)); break;
                case 3: ((LivingEntity) user).addStatusEffect(new StatusEffectInstance(StatusEffects.HASTE, 100, 0)); break;
                case 4: ((LivingEntity) user).addStatusEffect(new StatusEffectInstance(StatusEffects.MINING_FATIGUE, 100, 0)); break;
                case 5: ((LivingEntity) user).addStatusEffect(new StatusEffectInstance(StatusEffects.STRENGTH, 100, 0)); break;
                case 6: ((LivingEntity) user).addStatusEffect(new StatusEffectInstance(StatusEffects.INSTANT_DAMAGE, 100, 0)); break;
                case 7: ((LivingEntity) user).addStatusEffect(new StatusEffectInstance(StatusEffects.INSTANT_HEALTH, 100, 0)); break;
                case 8: ((LivingEntity) user).addStatusEffect(new StatusEffectInstance(StatusEffects.JUMP_BOOST, 100, 0)); break;
                case 9: ((LivingEntity) user).addStatusEffect(new StatusEffectInstance(StatusEffects.NAUSEA, 100, 0)); break;
                case 10: ((LivingEntity) user).addStatusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 100, 0)); break;
                case 11: ((LivingEntity) user).addStatusEffect(new StatusEffectInstance(StatusEffects.RESISTANCE, 100, 0)); break;
                case 12: ((LivingEntity) user).addStatusEffect(new StatusEffectInstance(StatusEffects.FIRE_RESISTANCE, 100, 0)); break;
                case 13: ((LivingEntity) user).addStatusEffect(new StatusEffectInstance(StatusEffects.WATER_BREATHING, 100, 0)); break;
                case 14: ((LivingEntity) user).addStatusEffect(new StatusEffectInstance(StatusEffects.INVISIBILITY, 100, 0)); break;
                case 15: ((LivingEntity) user).addStatusEffect(new StatusEffectInstance(StatusEffects.BLINDNESS, 100, 0)); break;
                case 16: ((LivingEntity) user).addStatusEffect(new StatusEffectInstance(StatusEffects.NIGHT_VISION, 100, 0)); break;
                case 17: ((LivingEntity) user).addStatusEffect(new StatusEffectInstance(StatusEffects.HUNGER, 100, 0)); break;
                case 18: ((LivingEntity) user).addStatusEffect(new StatusEffectInstance(StatusEffects.WEAKNESS, 100, 0)); break;
                case 19: ((LivingEntity) user).addStatusEffect(new StatusEffectInstance(StatusEffects.POISON, 100, 0)); break;
                case 20: ((LivingEntity) user).addStatusEffect(new StatusEffectInstance(StatusEffects.WITHER, 100, 0)); break;
                case 21: ((LivingEntity) user).addStatusEffect(new StatusEffectInstance(StatusEffects.HEALTH_BOOST, 100, 0)); break;
                case 22: ((LivingEntity) user).addStatusEffect(new StatusEffectInstance(StatusEffects.ABSORPTION, 100, 0)); break;
                case 23: ((LivingEntity) user).addStatusEffect(new StatusEffectInstance(StatusEffects.SATURATION, 100, 0)); break;
                case 24: ((LivingEntity) user).addStatusEffect(new StatusEffectInstance(StatusEffects.GLOWING, 100, 0)); break;
                case 25: ((LivingEntity) user).addStatusEffect(new StatusEffectInstance(StatusEffects.LEVITATION, 100, 0)); break;
                case 26: ((LivingEntity) user).addStatusEffect(new StatusEffectInstance(StatusEffects.LUCK, 100, 0)); break;
                case 27: ((LivingEntity) user).addStatusEffect(new StatusEffectInstance(StatusEffects.UNLUCK, 100, 0)); break;
                case 28: ((LivingEntity) user).addStatusEffect(new StatusEffectInstance(StatusEffects.SLOW_FALLING, 100, 0)); break;
                case 29: ((LivingEntity) user).addStatusEffect(new StatusEffectInstance(StatusEffects.CONDUIT_POWER, 100, 0)); break;
                case 30: ((LivingEntity) user).addStatusEffect(new StatusEffectInstance(StatusEffects.DOLPHINS_GRACE, 100, 0)); break;
                case 31: ((LivingEntity) user).addStatusEffect(new StatusEffectInstance(StatusEffects.BAD_OMEN, 100, 0)); break;
                case 32: ((LivingEntity) user).addStatusEffect(new StatusEffectInstance(StatusEffects.HERO_OF_THE_VILLAGE, 100, 0)); break;
                case 33: ((LivingEntity) user).addStatusEffect(new StatusEffectInstance(StatusEffects.DARKNESS, 100, 0)); break;
                default: break;
            }
        }
    }
}