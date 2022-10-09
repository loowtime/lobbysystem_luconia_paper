package net.luconia.lobbysystem.listener;

import net.luconia.lobbysystem.Lobbysystem;
import net.luconia.lobbysystem.utils.ItemBuilder;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;

public class InteractListener implements Listener {
    @EventHandler
    public void onInteract(PlayerInteractEvent event) {
        Player player = event.getPlayer();
        if (event.getAction().name().contains("RIGHT_CLICK")) {
            if (event.getItem() != null) {
                if (event.getItem().getType().equals(Material.CHEST)) {
                    Player p = event.getPlayer();
                    Inventory inventory = Bukkit.createInventory(null, 5 * 9, "§7» §l§eGameselector");
                    Bukkit.getScheduler().runTaskLaterAsynchronously(Lobbysystem.instance, () -> {
                        // Obere Reihe
                        inventory.setItem(0, new ItemBuilder(Material.YELLOW_SHULKER_BOX).setDisplayname("").setLore("").build());
                        inventory.setItem(1, new ItemBuilder(Material.STAINED_GLASS_PANE).setDisplayname("").setLore("").build());
                        inventory.setItem(2, new ItemBuilder(Material.STAINED_GLASS_PANE).setDisplayname("").setLore("").build());
                        inventory.setItem(3, new ItemBuilder(Material.STAINED_GLASS_PANE).setDisplayname("").setLore("").build());
                        inventory.setItem(4, new ItemBuilder(Material.STAINED_GLASS_PANE).setDisplayname("").setLore("").build());
                        inventory.setItem(5, new ItemBuilder(Material.STAINED_GLASS_PANE).setDisplayname("").setLore("").build());
                        inventory.setItem(6, new ItemBuilder(Material.STAINED_GLASS_PANE).setDisplayname("").setLore("").build());
                        inventory.setItem(7, new ItemBuilder(Material.STAINED_GLASS_PANE).setDisplayname("").setLore("").build());
                        inventory.setItem(8, new ItemBuilder(Material.YELLOW_SHULKER_BOX).setDisplayname("").setLore("").build());
                    }, 2L);

                    Bukkit.getScheduler().runTaskLaterAsynchronously(Lobbysystem.instance, () -> {
                        // Linke Seitenreihe
                        inventory.setItem(9, new ItemBuilder(Material.STAINED_GLASS_PANE).setDisplayname("").setLore("").build());
                        inventory.setItem(18, new ItemBuilder(Material.STAINED_GLASS_PANE).setDisplayname("").setLore("").build());
                        inventory.setItem(27, new ItemBuilder(Material.STAINED_GLASS_PANE).setDisplayname("").setLore("").build());
                        inventory.setItem(36, new ItemBuilder(Material.YELLOW_SHULKER_BOX).setDisplayname("").setLore("").build());
                    }, 3L);

                    Bukkit.getScheduler().runTaskLaterAsynchronously(Lobbysystem.instance, () -> {
                        // Rechte Seitenreihe
                        inventory.setItem(17, new ItemBuilder(Material.STAINED_GLASS_PANE).setDisplayname("").setLore("").build());
                        inventory.setItem(26, new ItemBuilder(Material.STAINED_GLASS_PANE).setDisplayname("").setLore("").build());
                        inventory.setItem(35, new ItemBuilder(Material.STAINED_GLASS_PANE).setDisplayname("").setLore("").build());
                        inventory.setItem(44, new ItemBuilder(Material.YELLOW_SHULKER_BOX).setDisplayname("").setLore("").build());
                    }, 4L);
                    Bukkit.getScheduler().runTaskLaterAsynchronously(Lobbysystem.instance, () -> {
                        // Untenreihe
                        inventory.setItem(37, new ItemBuilder(Material.STAINED_GLASS_PANE).setDisplayname("").setLore("").build());
                        inventory.setItem(38, new ItemBuilder(Material.STAINED_GLASS_PANE).setDisplayname("").setLore("").build());
                        inventory.setItem(39, new ItemBuilder(Material.STAINED_GLASS_PANE).setDisplayname("").setLore("").build());
                        inventory.setItem(40, new ItemBuilder(Material.STAINED_GLASS_PANE).setDisplayname("").setLore("").build());
                        inventory.setItem(41, new ItemBuilder(Material.STAINED_GLASS_PANE).setDisplayname("").setLore("").build());
                        inventory.setItem(42, new ItemBuilder(Material.STAINED_GLASS_PANE).setDisplayname("").setLore("").build());
                        inventory.setItem(43, new ItemBuilder(Material.STAINED_GLASS_PANE).setDisplayname("").setLore("").build());
                    }, 5L);
                    Bukkit.getScheduler().runTaskLaterAsynchronously(Lobbysystem.instance, () -> {
                        // Items
                        inventory.setItem(10, new ItemBuilder(Material.IRON_SWORD).setDisplayname("§eSMP").setLore("§a§oConnect to SMP server").setLocalizedName("smp").build());
                    }, 10L);
                    p.openInventory(inventory);
                }
            }
        }
    }
}
