package org.bernardo.o6smcmmoexpansion.stats.templates;

import org.bernardo.o6smcmmoexpansion.stats.APIs.StatsAPI;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;
import java.util.List;

public class StatsTemplate implements Listener {

    private final String MENU_PRINCIPAL = ChatColor.GRAY + "Menu de Status";
    private final String MENU_TOP_PLAYERS = ChatColor.GRAY + "Menu Top Players";
    private final String MENU_TOP_FACTIONS = ChatColor.GRAY + "Menu Top Factions";
    private final String MENU_TOP_MINING = ChatColor.GRAY + "Menu Top Mineração";
    private final String MENU_TOP_ACROBATICS = ChatColor.GRAY + "Menu Top Acrobacias";
    private final String MENU_TOP_ALCHEMY = ChatColor.GRAY + "Menu Top Alquimia";
    private final String MENU_TOP_ARCHERY = ChatColor.GRAY + "Menu Top Arqueiro";
    private final String MENU_TOP_AXES = ChatColor.GRAY + "Menu Top Machados";
    private final String MENU_TOP_EXCAVATION = ChatColor.GRAY + "Menu Top Escavação";
    private final String MENU_TOP_FISHING = ChatColor.GRAY + "Menu Top Pesca";
    private final String MENU_TOP_HERBALISM = ChatColor.GRAY + "Menu Top Herbalismo";
    private final String MENU_TOP_REPAIR = ChatColor.GRAY + "Menu Top Reparo";
    private final String MENU_TOP_SWORDS = ChatColor.GRAY + "Menu Top Espadas";
    private final String MENU_TOP_UNARMED = ChatColor.GRAY + "Menu Top Desarmado";
    private final String MENU_TOP_WOODCUTTING = ChatColor.GRAY + "Menu Top Lenhador";

    private final StatsAPI statsAPI = new StatsAPI();

    public void abrirMenuPrincipal(Player player) {
        Inventory inventory = Bukkit.createInventory(null, 5 * 9, MENU_PRINCIPAL);

        inventory.setItem(3, statsAPI.itemTopPlayer());
        inventory.setItem(4, statsAPI.perfilPlayer(player));
        inventory.setItem(5, statsAPI.itemTopFactions());

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

    public void abrirMenuTop(Player player, String tipo) {
        Inventory inventory;

        List<Integer> posicoesTop = Arrays.asList(21, 22, 23, 28, 29, 30, 31, 32, 33, 34);

        List<String> factionsUUID;
        List<Player> playersTop;

        if (tipo.equalsIgnoreCase("Players")) {
            inventory = Bukkit.createInventory(null, 5 * 9, MENU_TOP_PLAYERS);
        } else if (tipo.equalsIgnoreCase("Mining")) {
            inventory = Bukkit.createInventory(null, 5 * 9, MENU_TOP_MINING);
        } else if (tipo.equalsIgnoreCase("Acrobatics")) {
            inventory = Bukkit.createInventory(null, 5 * 9, MENU_TOP_ACROBATICS);
        } else if (tipo.equalsIgnoreCase("Alchemy")) {
            inventory = Bukkit.createInventory(null, 5 * 9, MENU_TOP_ALCHEMY);
        } else if (tipo.equalsIgnoreCase("Archery")) {
            inventory = Bukkit.createInventory(null, 5 * 9, MENU_TOP_ARCHERY);
        } else if (tipo.equalsIgnoreCase("Axes")) {
            inventory = Bukkit.createInventory(null, 5 * 9, MENU_TOP_AXES);
        } else if (tipo.equalsIgnoreCase("Excavation")) {
            inventory = Bukkit.createInventory(null, 5 * 9, MENU_TOP_EXCAVATION);
        } else if (tipo.equalsIgnoreCase("Fishing")) {
            inventory = Bukkit.createInventory(null, 5 * 9, MENU_TOP_FISHING);
        } else if (tipo.equalsIgnoreCase("Herbalism")) {
            inventory = Bukkit.createInventory(null, 5 * 9, MENU_TOP_HERBALISM);
        } else if (tipo.equalsIgnoreCase("Repair")) {
            inventory = Bukkit.createInventory(null, 5 * 9, MENU_TOP_REPAIR);
        } else if (tipo.equalsIgnoreCase("Swords")) {
            inventory = Bukkit.createInventory(null, 5 * 9, MENU_TOP_SWORDS);
        } else if (tipo.equalsIgnoreCase("Unarmed")) {
            inventory = Bukkit.createInventory(null, 5 * 9, MENU_TOP_UNARMED);
        } else if (tipo.equalsIgnoreCase("Woodcutting")) {
            inventory = Bukkit.createInventory(null, 5 * 9, MENU_TOP_WOODCUTTING);
        } else {
            inventory = Bukkit.createInventory(null, 5 * 9, MENU_TOP_FACTIONS);
        }

        inventory.setItem(36,statsAPI.itemVoltar());

        if (tipo.equalsIgnoreCase("Faction")) {
            for (int posicao : posicoesTop) {
                inventory.setItem(posicao,statsAPI.itemFactionTop(1,null));
            }

            player.openInventory(inventory);

            return;
        }

        for (int posicao : posicoesTop) {
            inventory.setItem(posicao, statsAPI.itemPlayerTop(1, null));
        }

        player.openInventory(inventory);
    }

    @EventHandler
    public void clickInventory(InventoryClickEvent e) {
        if (e.getView() != null && e.getView().getTitle() != null) {
            if (e.getView().getTitle().equalsIgnoreCase(MENU_PRINCIPAL)) {
                e.setCancelled(true);

                if (e.getCurrentItem() == null || !e.getCurrentItem().hasItemMeta()) {
                    return;
                }

                ItemMeta meta = e.getCurrentItem().getItemMeta();
                if (meta.getDisplayName() == null) {
                    return;
                }

                String display = meta.getDisplayName();
                Player player = (Player) e.getWhoClicked();

                player.closeInventory();
            } else if (e.getView().getTitle().equalsIgnoreCase(MENU_TOP_PLAYERS) || e.getView().getTitle().equalsIgnoreCase(MENU_TOP_ACROBATICS) ||
            e.getView().getTitle().equalsIgnoreCase(MENU_TOP_ALCHEMY) || e.getView().getTitle().equalsIgnoreCase(MENU_TOP_ARCHERY) ||
            e.getView().getTitle().equalsIgnoreCase(MENU_TOP_AXES) || e.getView().getTitle().equalsIgnoreCase(MENU_TOP_EXCAVATION) ||
            e.getView().getTitle().equalsIgnoreCase(MENU_TOP_FISHING) || e.getView().getTitle().equalsIgnoreCase(MENU_TOP_HERBALISM) ||
            e.getView().getTitle().equalsIgnoreCase(MENU_TOP_REPAIR) || e.getView().getTitle().equalsIgnoreCase(MENU_TOP_SWORDS) ||
            e.getView().getTitle().equalsIgnoreCase(MENU_TOP_UNARMED) || e.getView().getTitle().equalsIgnoreCase(MENU_TOP_WOODCUTTING) ||
            e.getView().getTitle().equalsIgnoreCase(MENU_TOP_MINING) || e.getView().getTitle().equalsIgnoreCase(MENU_TOP_FACTIONS)) {
                e.setCancelled(true);

                if (e.getCurrentItem() == null || !e.getCurrentItem().hasItemMeta()) {
                    return;
                }

                ItemMeta meta = e.getCurrentItem().getItemMeta();
                if (meta.getDisplayName() == null) {
                    return;
                }

                Player player = (Player) e.getWhoClicked();

                if (e.getCurrentItem().equals(statsAPI.itemVoltar())) {
                    player.closeInventory();

                    abrirMenuPrincipal(player);
                }
            }
        }
    }

}
