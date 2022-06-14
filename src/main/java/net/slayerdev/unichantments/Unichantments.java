package net.slayerdev.unichantments;

import net.fabricmc.api.ModInitializer;
import net.slayerdev.unichantments.effect.ModEffects;
import net.slayerdev.unichantments.enchantment.ModEnchantments;
import net.slayerdev.unichantments.util.ModLootTableModifiers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Unichantments implements ModInitializer {
	public static final String MOD_ID = "unichantments";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {

		ModLootTableModifiers.modifyLootTables();
		ModEffects.registerEffects();
		ModEnchantments.registerModEnchantments();

	}
}
