package net.morimori0317.gmrg;

import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.screens.PauseScreen;
import net.minecraftforge.client.event.ScreenEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModList;

public class GuiHandler {
    @SubscribeEvent
    public static void onGUI(ScreenEvent.InitScreenEvent.Post e) {
        if (e.getScreen() instanceof PauseScreen && e.getListenersList().size() > 0) {
            if (ModList.get().isLoaded("bettergamemenu")) return;

            Button feedback = (Button) e.getListenersList().get(3);

            Button reportbugs = (Button) e.getListenersList().get(4);

            if (feedback != null)
                e.removeListener(feedback);
            if (reportbugs != null)
                e.removeListener(reportbugs);
        }
    }
}
