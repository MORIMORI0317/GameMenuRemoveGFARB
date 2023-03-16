package net.morimori0317.gmrg.mixin;

import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.layouts.GridLayout;
import net.minecraft.client.gui.layouts.LayoutElement;
import net.minecraft.client.gui.layouts.LayoutSettings;
import net.minecraft.client.gui.screens.PauseScreen;
import net.morimori0317.gmrg.explatform.GMRGExpectPlatform;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(GridLayout.RowHelper.class)
public abstract class GridLayoutRowHelperMixin {


    @Shadow
    public abstract LayoutSettings newCellSettings();

    @Shadow
    public abstract <T extends LayoutElement> T addChild(T arg, int i, LayoutSettings arg2);

    @Inject(method = "addChild(Lnet/minecraft/client/gui/layouts/LayoutElement;I)Lnet/minecraft/client/gui/layouts/LayoutElement;", at = @At("HEAD"), cancellable = true)
    private <T extends LayoutElement> void addChildInject(T layoutElement, int i, CallbackInfoReturnable<T> cir) {

        if (layoutElement instanceof Button button && (button.getMessage() == PauseScreen.SEND_FEEDBACK || button.getMessage() == PauseScreen.REPORT_BUGS)) {
            button.active = button.visible = false;

            if (GMRGExpectPlatform.isRemoveGFARB())
                button.height = 0;

            cir.setReturnValue(this.addChild(layoutElement, i, newCellSettings().paddingTop(0)));
        }
    }
}
