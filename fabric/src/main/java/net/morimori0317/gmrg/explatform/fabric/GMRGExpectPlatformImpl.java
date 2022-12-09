package net.morimori0317.gmrg.explatform.fabric;

import net.fabricmc.loader.api.FabricLoader;

public class GMRGExpectPlatformImpl {
    public static boolean isRemoveGFARB() {
        return FabricLoader.getInstance().isModLoaded("modmenu");
    }
}
