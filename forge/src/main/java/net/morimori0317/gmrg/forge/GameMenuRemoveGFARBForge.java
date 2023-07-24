package net.morimori0317.gmrg.forge;

import com.google.common.base.Suppliers;
import net.minecraftforge.fml.IExtensionPoint;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.forgespi.language.IModFileInfo;
import net.minecraftforge.network.NetworkConstants;
import net.morimori0317.gmrg.GameMenuRemoveGFARB;
import org.apache.maven.artifact.versioning.DefaultArtifactVersion;

import java.util.function.Supplier;

@Mod(GameMenuRemoveGFARB.MODID)
public class GameMenuRemoveGFARBForge {
    private static final String FORGE_MOD_ID = "forge";
    private static final String MINECRAFT_MOD_ID = "minecraft";
    private static final String NEO_FORGE_DISPLAY_NAME = "NeoForge";
    private static final DefaultArtifactVersion EXIST_MOD_BUTTON_FORGE_VERSION_1194 = new DefaultArtifactVersion("45.1.15");
    private static final DefaultArtifactVersion EXIST_MOD_BUTTON_FORGE_VERSION_1201 = new DefaultArtifactVersion("47.1.25");
    private static final DefaultArtifactVersion MC_1194_VERSION = new DefaultArtifactVersion("1.19.4");
    private static final DefaultArtifactVersion MC_1201_VERSION = new DefaultArtifactVersion("1.20.1");
    private static final Supplier<DefaultArtifactVersion> CURRENT_FORGE_VERSION = Suppliers.memoize(() -> {
        IModFileInfo forgeMod = ModList.get().getModFileById(FORGE_MOD_ID);

        if (forgeMod == null) {
            return null;
        }

        return new DefaultArtifactVersion(forgeMod.versionString());
    });
    private static final Supplier<DefaultArtifactVersion> CURRENT_MC_VERSION = Suppliers.memoize(() -> new DefaultArtifactVersion(ModList.get().getModFileById(MINECRAFT_MOD_ID).versionString()));
    private static final Supplier<Boolean> NEO_FORGE = Suppliers.memoize(GameMenuRemoveGFARBForge::isNeoForge);

    public GameMenuRemoveGFARBForge() {
        ModLoadingContext.get().registerExtensionPoint(IExtensionPoint.DisplayTest.class, () -> new IExtensionPoint.DisplayTest(() -> NetworkConstants.IGNORESERVERONLY, (remote, isServer) -> true));
    }

    public static boolean existModButton() {
        if (NEO_FORGE.get()) {
            return false;
        }

        DefaultArtifactVersion currentForgeVersion = CURRENT_FORGE_VERSION.get();

        if (currentForgeVersion == null) {
            return false;
        }

        DefaultArtifactVersion existVersion;
        DefaultArtifactVersion currentMcVersion = CURRENT_MC_VERSION.get();

        if (currentMcVersion.compareTo(MC_1201_VERSION) >= 0) {
            existVersion = EXIST_MOD_BUTTON_FORGE_VERSION_1201;
        } else if (currentMcVersion.compareTo(MC_1194_VERSION) <= 0) {
            existVersion = EXIST_MOD_BUTTON_FORGE_VERSION_1194;
        } else {
            return false;
        }

        return currentForgeVersion.compareTo(EXIST_MOD_BUTTON_FORGE_VERSION_1194) >= 0;
    }

    private static boolean isNeoForge() {
        return ModList.get().getMods().stream()
                .filter(it -> FORGE_MOD_ID.equals(it.getModId()))
                .limit(1)
                .anyMatch(it -> NEO_FORGE_DISPLAY_NAME.equals(it.getDisplayName()));
    }
}
