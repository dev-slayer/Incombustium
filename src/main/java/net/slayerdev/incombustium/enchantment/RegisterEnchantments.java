package net.slayerdev.incombustium.enchantment;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.slayerdev.incombustium.Incombustium;

public class RegisterEnchantments {
    public static Enchantment INCOMBUSTIBLE = register("incombustible",
            new IncombustibleEnchantment(Enchantment.Rarity.VERY_RARE, EnchantmentTarget.BREAKABLE));
    public static Enchantment SPECTRAL = register("spectral",
            new SpectralEnchantment(Enchantment.Rarity.RARE, EnchantmentTarget.BREAKABLE));
    public static Enchantment EVERLASTING = register("everlasting",
            new EverlastingEnchantment(Enchantment.Rarity.RARE, EnchantmentTarget.BREAKABLE));
    public static Enchantment TIME = register("time",
            new ItemCurse(Enchantment.Rarity.RARE, EnchantmentTarget.BREAKABLE));
    public static Enchantment GRAVITATION = register("gravitation",
            new ItemCurse(Enchantment.Rarity.VERY_RARE, EnchantmentTarget.BREAKABLE));
    public static Enchantment CLUMSY = register("clumsy",
            new ItemCurse(Enchantment.Rarity.VERY_RARE, EnchantmentTarget.BREAKABLE));
    private static Enchantment register(String name, Enchantment enchantment) {
        return Registry.register(Registry.ENCHANTMENT, new Identifier(Incombustium.MOD_ID, name), enchantment);
    }

    public static void registerModEnchantments() {
        System.out.println("Registering Enchantments for " + Incombustium.MOD_ID);
    }
}
