package net.morimori0317.gmrg.forge;

import net.minecraftforge.fml.IExtensionPoint;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.network.NetworkConstants;
import net.morimori0317.gmrg.GameMenuRemoveGFARB;

@Mod(GameMenuRemoveGFARB.MODID)
public class GameMenuRemoveGFARBForge {
    public GameMenuRemoveGFARBForge() {
        ModLoadingContext.get().registerExtensionPoint(IExtensionPoint.DisplayTest.class, () -> new IExtensionPoint.DisplayTest(() -> NetworkConstants.IGNORESERVERONLY, (remote, isServer) -> true));
    }
}
