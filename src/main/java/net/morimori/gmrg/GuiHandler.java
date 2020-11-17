package net.morimori.gmrg;

import net.minecraft.client.gui.screen.IngameMenuScreen;
import net.minecraft.client.gui.widget.button.Button;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraftforge.client.event.GuiScreenEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class GuiHandler {
    @SubscribeEvent
    public static void onGUI(GuiScreenEvent.InitGuiEvent.Post e) {
        if (e.getGui() instanceof IngameMenuScreen) {
            Button feedback = (Button) e.getWidgetList().stream().filter(n -> {
                if (n instanceof Button) {
                    if (n.getMessage() instanceof TranslationTextComponent) {
                        return ((TranslationTextComponent) n.getMessage()).getKey().equals("menu.sendFeedback");
                    }
                }
                return false;
            }).findAny().orElseGet(null);
            Button reportbugs = (Button) e.getWidgetList().stream().filter(n -> {
                if (n instanceof Button) {
                    if (n.getMessage() instanceof TranslationTextComponent) {
                        return ((TranslationTextComponent) n.getMessage()).getKey().equals("menu.reportBugs");
                    }
                }
                return false;
            }).findAny().orElseGet(null);

            if (feedback != null)
                e.removeWidget(feedback);
            if (reportbugs != null)
                e.removeWidget(reportbugs);
        }
    }
}
