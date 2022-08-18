package net.slayerdev.incombustium.mixin;

import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.item.ItemStack;
import net.slayerdev.incombustium.enchantment.RegisterEnchantments;
import net.slayerdev.incombustium.util.RegisterTags;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(ItemEntity.class)
public abstract class IncombustibleMixin {
	@Shadow public abstract ItemStack getStack();

	@Inject(at = @At("HEAD"), method = "isFireImmune", cancellable = true)
	private void incombustible$FireImmuneChecks(CallbackInfoReturnable<Boolean> cir) {
		if(EnchantmentHelper.getLevel(RegisterEnchantments.INCOMBUSTIBLE, getStack()) == 1 || getStack().isIn(RegisterTags.Items.INFLAMMABLE) || getStack().isIn(RegisterTags.Items.INCOMBUSTIBLE)) {
			cir.setReturnValue(true);
		}
	}
	@Inject(at = @At("HEAD"), method = "damage", cancellable = true)
	public void incombustible$DamageImmuneChecks(DamageSource source, float amount, CallbackInfoReturnable<Boolean> cir) {
		if(EnchantmentHelper.getLevel(RegisterEnchantments.INCOMBUSTIBLE, getStack()) == 1 || getStack().isIn(RegisterTags.Items.INCOMBUSTIBLE) && !source.isOutOfWorld()) {
			cir.setReturnValue(false);
		}
	}
}
