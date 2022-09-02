package net.slayerdev.incombustium.util;

import com.mojang.datafixers.types.templates.Tag;
import net.minecraft.item.Item;
import net.minecraft.tag.TagBuilder;
import net.minecraft.tag.TagKey;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.slayerdev.incombustium.Incombustium;

public class RegisterTags {
    public static class Items {
        public static final TagKey<Item> INCOMBUSTIBLE = TagKey.of(Registry.ITEM_KEY, new Identifier("incombustium", "incombustible"));
        public static final TagKey<Item> INFLAMMABLE = TagKey.of(Registry.ITEM_KEY, new Identifier("incombustium", "inflammable"));
        public static final TagKey<Item> NO_GRAVITY = TagKey.of(Registry.ITEM_KEY, new Identifier("incombustium", "no_gravity"));
        public static final TagKey<Item> HAS_GLOWING = TagKey.of(Registry.ITEM_KEY, new Identifier("incombustium", "has_glowing"));

        private static TagKey<Item> createTag(String name) {
            return TagKey.of(Registry.ITEM_KEY, new Identifier(Incombustium.MOD_ID, name));
        }
    }
}
