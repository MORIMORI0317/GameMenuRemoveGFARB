package net.morimori0317.gmrg.explatform;

import dev.architectury.injectables.annotations.ExpectPlatform;

public class GMRGExpectPlatform {
    @ExpectPlatform
    public static boolean isRemoveGFARB() {
        throw new AssertionError();
    }
}
