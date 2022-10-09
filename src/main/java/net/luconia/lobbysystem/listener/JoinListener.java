package net.luconia.lobbysystem.listener;

import de.dytanic.cloudnet.CloudNet;
import de.dytanic.cloudnet.driver.CloudNetDriver;
import de.dytanic.cloudnet.ext.bridge.player.CloudPlayer;
import de.dytanic.cloudnet.ext.bridge.player.IPlayerManager;
import de.dytanic.cloudnet.ext.syncproxy.node.CloudNetSyncProxyModule;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.Plugin;
import org.bukkit.scoreboard.*;

import java.util.Arrays;

public class JoinListener implements Listener {
    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        // repeat all 1 second
        Plugin plugin = Bukkit.getPluginManager().getPlugin("Lobbysystem");
        Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {
            @Override
            public void run() {
                ScoreboardManager manager = Bukkit.getScoreboardManager();
                final Scoreboard board = manager.getNewScoreboard();
                IPlayerManager playerManager = CloudNetDriver.getInstance().getServicesRegistry().getFirstService(IPlayerManager.class);
                final Objective objective = board.registerNewObjective("test", "dummy");
                objective.setDisplaySlot(DisplaySlot.SIDEBAR);
                objective.setDisplayName("§e§lLuconia Network");
                Score score1 = objective.getScore("§7§m-------------------");
                score1.setScore(1);
                Score score2 = objective.getScore("§8| §fPlayers:");
                score2.setScore(3);
                Score score3 = objective.getScore("§8» §a" + playerManager.getOnlineCount() + "§8/§71000");
                // cloudnet proxy max players count
                score3.setScore(2);
                Score score4 = objective.getScore("");
                score4.setScore(4);
                Score score5 = objective.getScore("§8| §fRank:");
                score5.setScore(6);
                Score score6 = objective.getScore("§8» §9§l" + CloudNetDriver.getInstance().getPermissionManagement().getHighestPermissionGroup(CloudNetDriver.getInstance().getPermissionManagement().getUser(player.getUniqueId())).getName());
                score6.setScore(5);
                Score score7 = objective.getScore("§7§m-------------------§7");
                score7.setScore(7);
                Score score8 = objective.getScore("        §e§oluconia.net");
                score8.setScore(0);
                event.getPlayer().setScoreboard(board);
            }
        }, 10L);
        player.getInventory().clear();
        // gameselector
        //player.getInventory().setItem(4, new ItemBuilder(Material.COMPASS).setName("§9§l§oGameselector").toItemStack());
        // gadgetselector
        //player.getInventory().setItem(8, new ItemBuilder(Material.CHEST).setName("§e§l§oGadgetselector").toItemStack());
        ItemStack i = new ItemStack(Material.CHEST);
        ItemMeta im = i.getItemMeta();
        im.setDisplayName("§9§l§oGameselector");
        im.setLore(Arrays.asList("§7Choose your minigame..."));
        i.setItemMeta(im);
        event.getPlayer().getInventory().setItem(6, i);
        event.setJoinMessage("§8[§a+§8] §7" + event.getPlayer().getName());
    }
}
