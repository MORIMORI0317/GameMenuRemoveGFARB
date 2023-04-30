package net.morimori0317.gmrg.mixin;

import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.components.events.GuiEventListener;
import net.minecraft.client.gui.screens.PauseScreen;
import net.morimori0317.gmrg.explatform.GMRGExpectPlatform;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(PauseScreen.class)
public class PauseScreenMixin {
    @Inject(method = "init", at = @At("TAIL"))
    private void initInject(CallbackInfo ci) {
        if (!GMRGExpectPlatform.isModMenuIntegration())
            return;

        PauseScreen thiz = (PauseScreen) (Object) this;

        for (GuiEventListener child : thiz.children()) {
            if (child instanceof Button button) {
                if (GMRGExpectPlatform.isModMenuReplaceBugs() && GMRGExpectPlatform.isModMenuModsButton(button)) {
                    button.setWidth(204);
                    button.setX(thiz.width / 2 - 102);
                    break;
                }

                if (GMRGExpectPlatform.isModMenuIconModsButton(button)) {
                    button.setY(button.getY() - 20);
                    break;
                }
            }
        }
    }
}
