package net.morimori0317.gmrg.explatform.forge;

import net.minecraftforge.fml.ModList;

public class GMRGExpectPlatformImpl {
    public static boolean isRemoveGFARB() {
        return ModList.get().isLoaded("gamemenumodoption");
    }
}
