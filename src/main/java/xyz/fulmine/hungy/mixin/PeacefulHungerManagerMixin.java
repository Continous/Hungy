package xyz.fulmine.hungy.mixin;

import net.minecraft.entity.player.HungerManager;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.world.Difficulty;
import org.objectweb.asm.Opcodes;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(HungerManager.class)
public class PeacefulHungerManagerMixin {
	@Inject(at = @At(
			value = "FIELD",
			target = "Lnet/minecraft/entity/player/HungerManager;saturationLevel:F",
			opcode = Opcodes.GETFIELD,
			ordinal = 0), method = "update(Lnet/minecraft/entity/player/PlayerEntity;)V")
	private void alwaysHungry(PlayerEntity player, CallbackInfo info) {
		if (((HungerManager)(Object)this).getSaturationLevel() <= 0 && player.getWorld().getDifficulty() == Difficulty.PEACEFUL) {
			((HungerManager)(Object)this).setFoodLevel(Math.max(((HungerManager)(Object)this).getFoodLevel() - 1, 0));
		}
	}
}