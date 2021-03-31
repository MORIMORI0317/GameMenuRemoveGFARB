package net.morimori.gmrg;

import net.minecraft.client.gui.screen.IngameMenuScreen;
import net.minecraft.client.gui.widget.button.Button;
import net.minecraftforge.client.event.GuiScreenEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class GuiHandler {
    @SubscribeEvent
    public static void onGUI(GuiScreenEvent.InitGuiEvent.Post e) {
        if (e.getGui() instanceof IngameMenuScreen) {
            Button feedback = (Button) e.getWidgetList().get(3);

            Button reportbugs = (Button) e.getWidgetList().get(4);

            if (feedback != null)
                e.removeWidget(feedback);
            if (reportbugs != null)
                e.removeWidget(reportbugs);

        }
    }
}
