package net.luconia.lobbysystem.utils;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;

public class ItemAPI {
    private ItemStack item;
    private ItemMeta meta;

    public ItemAPI(Material material) {
        this.item = new ItemStack(material, 1);
        this.meta = this.item.getItemMeta();
    }

    public ItemAPI(Material material, short subID) {
        this.item = new ItemStack(material, 1, subID);
        this.meta = this.item.getItemMeta();
    }

    public ItemAPI setName(String displayname) {
        this.meta.setDisplayName(displayname);
        return this;
    }

    public ItemAPI setLore(String... lore) {
        this.meta.setLore(Arrays.asList(lore));
        return this;
    }

    public ItemStack build() {
        this.item.setItemMeta(this.meta);
        return this.item;
    }
}