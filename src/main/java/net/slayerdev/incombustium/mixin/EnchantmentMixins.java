package net.slayerdev.incombustium.mixin;

import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.slayerdev.incombustium.enchantment.RegisterEnchantments;
import net.slayerdev.incombustium.util.RegisterTags;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;;

@Mixin(ItemEntity.class)
public abstract class EnchantmentMixins extends Entity {

	@Shadow private int itemAge;
	@Final @Shadow private static int NEVER_DESPAWN_AGE;
	@Shadow public abstract ItemStack getStack();

	public EnchantmentMixins(EntityType<?> type, World world) {
		super(type, world);
	}

	@Inject(at = @At("TAIL"), method = "<init>(Lnet/minecraft/world/World;DDDLnet/minecraft/item/ItemStack;)V")
	public void incombustible$Everlasting(World world, double x, double y, double z, ItemStack stack, CallbackInfo ci) {
		if(EnchantmentHelper.getLevel(RegisterEnchantments.EVERLASTING, stack) > 0) {
			this.itemAge = this.itemAge + -6000 * EnchantmentHelper.getLevel(RegisterEnchantments.EVERLASTING, stack);
			this.itemAge = Math.max(this.itemAge, NEVER_DESPAWN_AGE + 1);
		}
		if(EnchantmentHelper.getLevel(RegisterEnchantments.TIME, stack) > 0) {
			this.itemAge = this.itemAge + 4800;
		}
	}
	@Inject(at = @At("HEAD"), method = "isFireImmune", cancellable = true)
	private void incombustible$FireImmuneChecks(CallbackInfoReturnable<Boolean> cir) {
		if(EnchantmentHelper.getLevel(RegisterEnchantments.INCOMBUSTIBLE, getStack()) > 0 || getStack().isIn(RegisterTags.Items.INFLAMMABLE) || getStack().isIn(RegisterTags.Items.INCOMBUSTIBLE)) {
			cir.setReturnValue(true);
		}
	}
	@Inject(at = @At("HEAD"), method = "damage", cancellable = true)
	public void incombustible$DamageImmuneChecks(DamageSource source, float amount, CallbackInfoReturnable<Boolean> cir) {
		if(EnchantmentHelper.getLevel(RegisterEnchantments.INCOMBUSTIBLE, getStack()) > 0 || getStack().isIn(RegisterTags.Items.INCOMBUSTIBLE) && !source.isOutOfWorld()) {
			cir.setReturnValue(false);
		}
	}
	@Inject(at = @At("TAIL"), method = "<init>(Lnet/minecraft/world/World;DDDLnet/minecraft/item/ItemStack;)V")
	public void incombustible$SpectralEnchantment(World world, double x, double y, double z, ItemStack stack, CallbackInfo ci) {
		if(EnchantmentHelper.getLevel(RegisterEnchantments.SPECTRAL, stack) > 0 || getStack().isIn(RegisterTags.Items.HAS_GLOWING)) {
			setGlowing(true);
		}
	}
	@Inject(at = @At("TAIL"), method = "<init>(Lnet/minecraft/world/World;DDDLnet/minecraft/item/ItemStack;)V")
	public void incombustible$GravitationCurse(World world, double x, double y, double z, ItemStack stack, CallbackInfo ci) {
		if(EnchantmentHelper.getLevel(RegisterEnchantments.GRAVITATION, stack) > 0 || getStack().isIn(RegisterTags.Items.NO_GRAVITY)) {
			setNoGravity(true);
		}
	}
}