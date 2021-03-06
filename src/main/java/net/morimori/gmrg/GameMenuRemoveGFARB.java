package net.morimori.gmrg;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod("gamemenuremovegfarb")
public class GameMenuRemoveGFARB {

    public GameMenuRemoveGFARB() {
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::doClientStuff);
    }

    private void doClientStuff(final FMLClientSetupEvent e) {
        MinecraftForge.EVENT_BUS.register(GuiHandler.class);
    }
}
