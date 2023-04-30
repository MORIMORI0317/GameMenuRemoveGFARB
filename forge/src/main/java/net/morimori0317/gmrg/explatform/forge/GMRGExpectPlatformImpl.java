package net.morimori0317.gmrg.explatform.forge;

import net.minecraft.client.gui.components.Button;
import net.minecraftforge.fml.ModList;

public class GMRGExpectPlatformImpl {
    public static boolean isRemoveGMRGSpace() {
        return ModList.get().isLoaded("gamemenumodoption");
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
