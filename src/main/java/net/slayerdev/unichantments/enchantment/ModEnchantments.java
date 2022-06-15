package net.slayerdev.unichantments.enchantment;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.slayerdev.unichantments.Unichantments;

public class ModEnchantments {

    public static Enchantment EVOCATION = register("evocation",
            new EvocationEnchantment(Enchantment.Rarity.UNCOMMON,
                    EnchantmentTarget.BREAKABLE, EquipmentSlot.MAINHAND));

    public static Enchantment CONDUCTOR = register("conductor",
            new ConductorEnchantment(Enchantment.Rarity.UNCOMMON,
                    EnchantmentTarget.ARMOR));

    public static Enchantment KERFUFFLE = register("kerfuffle",
            new ConductorEnchantment(Enchantment.Rarity.RARE,
                    EnchantmentTarget.BOW));
    private static Enchantment register(String name, Enchantment enchantment) {
        return Registry.register(Registry.ENCHANTMENT, new Identifier(Unichantments.MOD_ID, name), enchantment);
    }

    public static void registerModEnchantments() {
        System.out.println("Registering Enchantments for " + Unichantments.MOD_ID);
    }
}
