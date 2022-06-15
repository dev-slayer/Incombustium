package net.slayerdev.unichantments.effect;

import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.slayerdev.unichantments.Unichantments;

public class ModEffects {
    public static final StatusEffect EVOCATION = new EvocationEffect();
    public static final StatusEffect RANDOM = new RandomEffect();

    public static void registerEffects() {
        Registry.register(Registry.STATUS_EFFECT, new Identifier("unichantments", "evocation"), EVOCATION);
        Registry.register(Registry.STATUS_EFFECT, new Identifier("unichantments", "random"), RANDOM);
    }
}
