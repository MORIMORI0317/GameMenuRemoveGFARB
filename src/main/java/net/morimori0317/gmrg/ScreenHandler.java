package net.morimori0317.gmrg;

import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.components.events.GuiEventListener;
import net.minecraft.client.gui.screens.PauseScreen;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.network.chat.contents.TranslatableContents;
import net.minecraftforge.client.event.ScreenEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModList;

import java.util.List;

public class ScreenHandler {
    @SubscribeEvent
    public static void onScreenInit(ScreenEvent.Init.Post e) {
        if (!(e.getScreen() instanceof PauseScreen pauseScreen) || !pauseScreen.showPauseMenu) return;

        if (ModList.get().isLoaded("bettergamemenu")) return;

        Button feedback = findButton(e.getListenersList(),"menu.sendFeedback");

        Button reportbugs = findButton(e.getListenersList(),"menu.reportBugs");

        if (feedback != null)
            e.removeListener(feedback);
        if (reportbugs != null)
            e.removeListener(reportbugs);
    }

    private static Button findButton(List<GuiEventListener> listeners, String name) {
        for (GuiEventListener listener : listeners) {
            if (listener instanceof Button button && button.getMessage() instanceof MutableComponent mutableComponent && mutableComponent.getContents() instanceof TranslatableContents translatableContents) {
                if (translatableContents.getKey().equals(name))
                    return button;
            }
        }
        return null;
    }
}
