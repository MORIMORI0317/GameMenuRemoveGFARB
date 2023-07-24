package net.morimori0317.gmrg.explatform.forge;

import net.minecraft.client.gui.components.Button;
import net.minecraftforge.fml.ModList;
import net.morimori0317.gmrg.forge.GameMenuRemoveGFARBForge;

public class GMRGExpectPlatformImpl {
    public static boolean isRemoveGMRGSpace() {
        return ModList.get().isLoaded("gamemenumodoption") || GameMenuRemoveGFARBForge.existModButton();
    }

    public static boolean isModMenuIntegration() {
        return false;
    }

    public static boolean isModMenuReplaceBugs() {
        return false;
    }

    public static boolean isModMenuModsButton(Button button) {
        return false;
    }

    public static boolean isModMenuIconModsButton(Button button) {
        return false;
    }

}
