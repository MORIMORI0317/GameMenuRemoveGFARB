package net.morimori0317.gmrg.explatform.fabric;

import com.terraformersmc.modmenu.config.ModMenuConfig;
import com.terraformersmc.modmenu.gui.widget.ModMenuButtonWidget;
import com.terraformersmc.modmenu.gui.widget.UpdateCheckerTexturedButtonWidget;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.client.gui.components.Button;

public class GMRGExpectPlatformImpl {
    public static boolean isRemoveGMRGSpace() {
        if (isModMenuIntegration())
            return ModMenuConfig.GAME_MENU_BUTTON_STYLE.getValue() == ModMenuConfig.GameMenuButtonStyle.BELOW_BUGS;

        return false;
    }

    public static boolean isModMenuIntegration() {
        if (isLoadedModMenu())
            return ModMenuConfig.MODIFY_GAME_MENU.getValue();
        return false;
    }

    public static boolean isModMenuReplaceBugs() {
        if (isLoadedModMenu())
            return ModMenuConfig.GAME_MENU_BUTTON_STYLE.getValue() == ModMenuConfig.GameMenuButtonStyle.REPLACE_BUGS;

        return false;
    }

    private static boolean isLoadedModMenu() {
        return FabricLoader.getInstance().isModLoaded("modmenu");
    }

    public static boolean isModMenuModsButton(Button button) {
        return button instanceof ModMenuButtonWidget;
    }

    public static boolean isModMenuIconModsButton(Button button) {
        return button instanceof UpdateCheckerTexturedButtonWidget;
    }

}
