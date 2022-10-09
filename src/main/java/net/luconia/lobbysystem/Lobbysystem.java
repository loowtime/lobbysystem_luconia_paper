package net.luconia.lobbysystem;

import net.luconia.lobbysystem.listener.InteractListener;
import net.luconia.lobbysystem.listener.InventoryClickListener;
import net.luconia.lobbysystem.listener.JoinListener;
import net.luconia.lobbysystem.listener.ProtectListener;
import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

public final class Lobbysystem extends JavaPlugin {
    public static Plugin instance;

    @Override
    public void onEnable() {
        instance = this;
        getLogger().info("§e§lLUCONIA§7.§e§lNET §8| §aLobbysystem is enabled!");
        Bukkit.getPluginManager().registerEvents(new JoinListener(), this);
        Bukkit.getPluginManager().registerEvents(new InteractListener(), this);
        Bukkit.getPluginManager().registerEvents(new ProtectListener(), this);
        Bukkit.getPluginManager().registerEvents(new InventoryClickListener(), this);
    }

    @Override
    public void onDisable() {
        getLogger().info("§e§lLUCONIA§7.§e§lNET §8| §cLobbysystem is disabled!");
    }

    public Lobbysystem getInstance() {
        return (Lobbysystem) instance;
    }
}
