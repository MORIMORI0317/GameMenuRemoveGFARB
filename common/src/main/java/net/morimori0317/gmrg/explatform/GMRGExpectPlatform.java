package net.morimori0317.gmrg.explatform;

import dev.architectury.injectables.annotations.ExpectPlatform;
import net.minecraft.client.gui.components.Button;

public class GMRGExpectPlatform {
    @ExpectPlatform
    public static boolean isRemoveGMRGSpace() {
        throw new AssertionError();
    }

    @ExpectPlatform
    public static boolean isModMenuIntegration() {
        throw new AssertionError();
    }

    @ExpectPlatform
    public static boolean isModMenuReplaceBugs() {
        throw new AssertionError();
    }


    @ExpectPlatform
    public static boolean isModMenuModsButton(Button button) {
        throw new AssertionError();
    }

    @ExpectPlatform
    public static boolean isModMenuIconModsButton(Button button) {
        throw new AssertionError();
    }
}
