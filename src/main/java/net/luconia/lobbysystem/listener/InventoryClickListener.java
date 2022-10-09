package net.luconia.lobbysystem.listener;

import de.dytanic.cloudnet.CloudNet;
import de.dytanic.cloudnet.ext.bridge.BridgePlayerManager;
import de.dytanic.cloudnet.ext.bridge.node.CloudNetBridgeModule;
import de.dytanic.cloudnet.ext.bridge.player.ICloudPlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.jetbrains.annotations.NotNull;
import java.util.List;

public class InventoryClickListener implements Listener {
    private BridgePlayerManager playerManager;

    @EventHandler
    public void onInventoryClick(InventoryClickEvent event) {
        if (event.getCurrentItem() == null) return;
        if (event.getView().getTitle() == "§7» §l§eGameselector") {
            Player player = (Player) event.getWhoClicked();
            event.setCancelled(true);
            if (event.getCurrentItem().getItemMeta().hasLocalizedName()) {
                switch (event.getCurrentItem().getItemMeta().getLocalizedName()) {
                    case "smp":
                        // send player to server smp-1 with cloudnet api

                        player.sendMessage("§7» §aDu wirst nun zum Server §eSMP §averbunden!");
                        player.sendTitle("§a§lConnecting to §e§lSMP!", "§7» §aPlease wait a moment!");
                        player.closeInventory();
                        break;
                }
            }
        }
    }
}
