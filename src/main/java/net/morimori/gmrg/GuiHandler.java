package net.morimori.gmrg;

import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.screens.PauseScreen;
import net.minecraftforge.client.event.GuiScreenEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModList;

public class GuiHandler {
    @SubscribeEvent
    public static void onGUI(GuiScreenEvent.InitGuiEvent.Post e) {
        if (e.getGui() instanceof PauseScreen && e.getWidgetList().size() > 0) {
            if (ModList.get().isLoaded("bettergamemenu")) return;

            Button feedback = (Button) e.getWidgetList().get(3);

            Button reportbugs = (Button) e.getWidgetList().get(4);

            if (feedback != null)
                e.removeWidget(feedback);
            if (reportbugs != null)
                e.removeWidget(reportbugs);
        }
    }
}
