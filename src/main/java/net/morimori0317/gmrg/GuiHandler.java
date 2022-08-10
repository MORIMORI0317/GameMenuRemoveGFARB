package net.morimori0317.gmrg;

import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.components.events.GuiEventListener;
import net.minecraft.client.gui.screens.PauseScreen;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraftforge.client.event.ScreenEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModList;

import java.util.List;

public class GuiHandler {
    @SubscribeEvent
    public static void onGUI(ScreenEvent.InitScreenEvent.Post e) {
        if (e.getScreen() instanceof PauseScreen pauseScreen && pauseScreen.showPauseMenu) {
            if (ModList.get().isLoaded("bettergamemenu")) return;

            Button feedback = findButton(e.getListenersList(), "menu.sendFeedback", 3);
            Button reportbugs = findButton(e.getListenersList(), "menu.reportBugs", 4);

            if (feedback != null)
                e.removeListener(feedback);
            if (reportbugs != null)
                e.removeListener(reportbugs);
        }
    }

    private static Button findButton(List<GuiEventListener> listeners, String name, int number) {
        for (GuiEventListener listener : listeners) {
            if (listener instanceof Button button && button.getMessage() instanceof TranslatableComponent translatableComponent && name.equals(translatableComponent.getKey()))
                return button;
        }

        if (listeners.size() > number && listeners.get(number) instanceof Button button)
            return button;
        return null;
    }
}
