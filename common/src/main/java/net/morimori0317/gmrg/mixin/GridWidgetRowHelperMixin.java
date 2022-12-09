package net.morimori0317.gmrg.mixin;

import net.minecraft.client.gui.components.AbstractWidget;
import net.minecraft.client.gui.components.GridWidget;
import net.minecraft.client.gui.components.LayoutSettings;
import net.minecraft.client.gui.screens.PauseScreen;
import net.morimori0317.gmrg.explatform.GMRGExpectPlatform;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(GridWidget.RowHelper.class)
public abstract class GridWidgetRowHelperMixin {

    @Shadow
    public abstract <T extends AbstractWidget> T addChild(T abstractWidget, int i, LayoutSettings layoutSettings);

    @Shadow
    public abstract LayoutSettings newCellSettings();

    @Inject(method = "addChild(Lnet/minecraft/client/gui/components/AbstractWidget;I)Lnet/minecraft/client/gui/components/AbstractWidget;", at = @At("HEAD"), cancellable = true)
    private <T extends AbstractWidget> void addChildInject(T abstractWidget, int i, CallbackInfoReturnable<T> cir) {
        if (abstractWidget != null && (abstractWidget.getMessage() == PauseScreen.SEND_FEEDBACK || abstractWidget.getMessage() == PauseScreen.REPORT_BUGS)) {
            abstractWidget.active = abstractWidget.visible = false;

            if (GMRGExpectPlatform.isRemoveGFARB())
                abstractWidget.height = 0;

            cir.setReturnValue(this.addChild(abstractWidget, i, newCellSettings().paddingTop(0)));
        }
    }
}
