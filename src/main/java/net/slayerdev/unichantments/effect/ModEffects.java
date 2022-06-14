package net.slayerdev.unichantments.effect;

import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.slayerdev.unichantments.Unichantments;

public class ModEffects {
    public static StatusEffect EVOCATION;

    public static StatusEffect registerStatusEffect(String name) {
        return Registry.register(Registry.STATUS_EFFECT, new Identifier(Unichantments.MOD_ID, name),
                new EvocationEffect(StatusEffectCategory.HARMFUL, 3124687));
    }

    public static void registerEffects() {
        EVOCATION = registerStatusEffect("evocation");
    }
}
