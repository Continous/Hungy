package xyz.fulmine.hungy.mixin;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.world.Difficulty;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;
import xyz.fulmine.hungy.config.ConfigHandler;

@Mixin(PlayerEntity.class)
public class PretendNotPeacefulRedirectMixin {

    // Initialize YACL config
    static {
        ConfigHandler.initialize();
    }

    @Redirect(method = "tickMovement()V", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/World;getDifficulty()Lnet/minecraft/world/Difficulty;"))
    private Difficulty pretendItsNotPeaceful(World world) {
        return ConfigHandler.getHungyDifficulty();
    }
}
