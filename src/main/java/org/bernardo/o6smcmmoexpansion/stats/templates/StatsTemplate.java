package org.bernardo.o6smcmmoexpansion.stats.templates;

import org.bernardo.o6smcmmoexpansion.stats.APIs.StatsAPI;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;

public class StatsTemplate implements Listener {

    private final String MENU_PRINCIPAL = ChatColor.GRAY + "Menu de Status";

    private final StatsAPI statsAPI = new StatsAPI();

    public void abrirMenuPrincipal(Player player) {
        Inventory inventory = Bukkit.createInventory(null, 5 * 9, MENU_PRINCIPAL);

        inventory.setItem(4, statsAPI.perfilPlayer(player));

        inventory.setItem(19, statsAPI.itemMining(player));
        inventory.setItem(20, statsAPI.itemAcrobatics(player));
        inventory.setItem(21, statsAPI.itemAlchemy(player));
        inventory.setItem(22, statsAPI.itemArchery(player));
        inventory.setItem(23, statsAPI.itemAxes(player));
        inventory.setItem(24, statsAPI.itemExcavation(player));
        inventory.setItem(25, statsAPI.itemFishing(player));

        inventory.setItem(29, statsAPI.itemHerbalism(player));
        inventory.setItem(30, statsAPI.itemRepair(player));
        inventory.setItem(31, statsAPI.itemSwords(player));
        inventory.setItem(32, statsAPI.itemUnarmed(player));
        inventory.setItem(33, statsAPI.itemWoodcutting(player));

        player.openInventory(inventory);
    }

    @EventHandler
    public void clickInventory(InventoryClickEvent e) {
        if (e.getView() != null && e.getView().getTitle() != null) {
            if (e.getView().getTitle().equalsIgnoreCase(MENU_PRINCIPAL)) {
                e.setCancelled(true);
            }
        }
    }

}
