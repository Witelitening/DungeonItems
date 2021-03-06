package codes.C13H10.dungeonitems.listeners;

import codes.C13H10.dungeonitems.utils.Utils;
import net.minecraft.client.Minecraft;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.entity.player.ItemTooltipEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.util.EnumChatFormatting;


public class PlayerListener {
    @SubscribeEvent()
    public void onItemTooltip(ItemTooltipEvent e) {
        ItemStack hoveredItem = e.itemStack;
        int ItemQuality = Utils.getNBTInteger(hoveredItem, "ExtraAttributes", "baseStatBoostPercentage");
        if(ItemQuality > 0) {
            int insertAt = e.toolTip.size();
            insertAt--; // 1 line for the rarity
            if (Minecraft.getMinecraft().gameSettings.advancedItemTooltips) {
                insertAt -= 2; // 1 line for the item name, and 1 line for the nbt
                if (e.itemStack.isItemDamaged()) {
                    insertAt--; // 1 line for damage
                }
            }
            String message = String.format(EnumChatFormatting.GREEN + "Dungeon Item Quality: " + EnumChatFormatting.GOLD + "%s/50", ItemQuality);

            e.toolTip.add(insertAt, message);
        }
    }
}
