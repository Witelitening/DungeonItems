package codes.C13H10.dungeonitems;

import codes.C13H10.dungeonitems.listeners.PlayerListener;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;



@Mod(modid = "dungeonitems", name = "Dungeon Items", version = "1.0.2", clientSideOnly = true, acceptedMinecraftVersions = "1.8.9-11.15.1.2318-1.8.9")
public class DungeonItems {
    private PlayerListener playerListener = new PlayerListener();
    @Mod.EventHandler
    public void init(FMLInitializationEvent event)
    {
        MinecraftForge.EVENT_BUS.register(playerListener);
    }
}
