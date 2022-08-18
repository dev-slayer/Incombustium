package net.slayerdev.incombustium;

import net.fabricmc.api.ModInitializer;
import net.slayerdev.incombustium.enchantment.RegisterEnchantments;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Incombustium implements ModInitializer {
	public static final String MOD_ID = "incombustium";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);
	@Override
	public void onInitialize() {
		RegisterEnchantments.registerModEnchantments();
	}
}
