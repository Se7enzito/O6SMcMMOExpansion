package org.bernardo.o6smcmmoexpansion.stats.APIs;

import com.gmail.nossr50.api.ExperienceAPI;
import com.gmail.nossr50.datatypes.skills.SkillType;
import org.bernardo.o6smcmmoexpansion.APIs.HeadsAPI;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;

public class StatsAPI {

    public ItemStack itemVoltar() {
        ItemStack itemStack = new ItemStack(Material.ARROW);
        ItemMeta meta = itemStack.getItemMeta();

        meta.setDisplayName(ChatColor.YELLOW + "Voltar");
        meta.setLore(Arrays.asList(ChatColor.GRAY + "Clique para voltar ao menu principal"));

        itemStack.setItemMeta(meta);

        return itemStack;
    }

    public ItemStack perfilPlayer(Player player) {
        String name = player.getName();
        int levelTotal = ExperienceAPI.getPowerLevel(player);

        ItemStack itemStack = HeadsAPI.getPlayerSkull(name);
        ItemMeta meta = itemStack.getItemMeta();

        meta.setDisplayName(ChatColor.YELLOW + name + " " + ChatColor.GRAY + "[" + ChatColor.GREEN + levelTotal + ChatColor.GRAY + "]");
        meta.setLore(Arrays.asList(ChatColor.GRAY + "Nível Total: " + ChatColor.GREEN + levelTotal, "",
                ChatColor.GRAY + "Mineração: " + ChatColor.GREEN + ExperienceAPI.getLevel(player, SkillType.ARCHERY.getName()),
                ChatColor.GRAY + "Acrobacias: " + ChatColor.GREEN + ExperienceAPI.getLevel(player, SkillType.ACROBATICS.getName()),
                ChatColor.GRAY + "Alquimia: " + ChatColor.GREEN + ExperienceAPI.getLevel(player,SkillType.ALCHEMY.getName()),
                ChatColor.GRAY + "Arqueiro: " + ChatColor.GREEN + ExperienceAPI.getLevel(player,SkillType.ARCHERY.getName()),
                ChatColor.GRAY + "Machados: " + ChatColor.GREEN + ExperienceAPI.getLevel(player,SkillType.AXES.getName()),
                ChatColor.GRAY + "Escavação: " + ChatColor.GREEN + ExperienceAPI.getLevel(player,SkillType.EXCAVATION.getName()),
                ChatColor.GRAY + "Pesca: " + ChatColor.GREEN + ExperienceAPI.getLevel(player,SkillType.FISHING.getName()),
                ChatColor.GRAY + "Herbalismo: " + ChatColor.GREEN + ExperienceAPI.getLevel(player,SkillType.HERBALISM.getName()),
                ChatColor.GRAY + "Reparo: " + ChatColor.GREEN + ExperienceAPI.getLevel(player,SkillType.REPAIR.getName()),
                ChatColor.GRAY + "Espadas: " + ChatColor.GREEN + ExperienceAPI.getLevel(player,SkillType.SWORDS.getName()),
                ChatColor.GRAY + "Desarmado: " + ChatColor.GREEN + ExperienceAPI.getLevel(player,SkillType.UNARMED.getName()),
                ChatColor.GRAY + "Lenhador: " + ChatColor.GREEN + ExperienceAPI.getLevel(player,SkillType.WOODCUTTING.getName())));



        itemStack.setItemMeta(meta);

        return itemStack;
    }

    public ItemStack itemMining(Player player) {
        int level = ExperienceAPI.getLevel(player,SkillType.MINING.getName());
        int posicao = 0;

        ItemStack itemStack = new ItemStack(Material.DIAMOND_PICKAXE);
        ItemMeta meta = itemStack.getItemMeta();

        meta.setDisplayName(ChatColor.YELLOW + "Mineração " + ChatColor.GRAY + "[" + ChatColor.GREEN + level + ChatColor.GRAY + "]");
        meta.setLore(Arrays.asList(ChatColor.GRAY + "Sua posição: " + ChatColor.GREEN + posicao + "°", "", ChatColor.GRAY + "Clique para abrir o menu de top " +
                "players"));

        itemStack.setItemMeta(meta);

        return itemStack;
    }

    public ItemStack itemAcrobatics(Player player) {
        int level = ExperienceAPI.getLevel(player,SkillType.ACROBATICS.getName());
        int posicao = 0;

        ItemStack itemStack = new ItemStack(Material.DIAMOND_BOOTS);
        ItemMeta meta = itemStack.getItemMeta();

        meta.setDisplayName(ChatColor.YELLOW + "Acrobacias " + ChatColor.GRAY + "[" + ChatColor.GREEN + level + ChatColor.GRAY + "]");
        meta.setLore(Arrays.asList(ChatColor.GRAY + "Sua posição: " + ChatColor.GREEN + posicao + "°", "", ChatColor.GRAY + "Clique para abrir o menu de top " +
                "players"));

        itemStack.setItemMeta(meta);

        return itemStack;
    }

    public ItemStack itemAlchemy(Player player) {
        int level = ExperienceAPI.getLevel(player,SkillType.ALCHEMY.getName());
        int posicao = 0;

        ItemStack itemStack = new ItemStack(Material.BREWING_STAND_ITEM);
        ItemMeta meta = itemStack.getItemMeta();

        meta.setDisplayName(ChatColor.YELLOW + "Alquimia " + ChatColor.GRAY + "[" + ChatColor.GREEN + level + ChatColor.GRAY + "]");
        meta.setLore(Arrays.asList(ChatColor.GRAY + "Sua posição: " + ChatColor.GREEN + posicao + "°", "", ChatColor.GRAY + "Clique para abrir o menu de top " +
                "players"));

        itemStack.setItemMeta(meta);

        return itemStack;
    }

    public ItemStack itemArchery(Player player) {
        int level = ExperienceAPI.getLevel(player,SkillType.ARCHERY.getName());
        int posicao = 0;

        ItemStack itemStack = new ItemStack(Material.BOW);
        ItemMeta meta = itemStack.getItemMeta();

        meta.setDisplayName(ChatColor.YELLOW + "Arqueiro " + ChatColor.GRAY + "[" + ChatColor.GREEN + level + ChatColor.GRAY + "]");
        meta.setLore(Arrays.asList(ChatColor.GRAY + "Sua posição: " + ChatColor.GREEN + posicao + "°", "", ChatColor.GRAY + "Clique para abrir o menu de top " +
                "players"));

        itemStack.setItemMeta(meta);

        return itemStack;
    }

    public ItemStack itemAxes(Player player) {
        int posicao = ExperienceAPI.getLevel(player,SkillType.AXES.getName());
        int level = 0;

        ItemStack itemStack = new ItemStack(Material.DIAMOND_AXE);
        ItemMeta meta = itemStack.getItemMeta();

        meta.setDisplayName(ChatColor.YELLOW + "Machados " + ChatColor.GRAY + "[" + ChatColor.GREEN + level + ChatColor.GRAY + "]");
        meta.setLore(Arrays.asList(ChatColor.GRAY + "Sua posição: " + ChatColor.GREEN + posicao + "°", "", ChatColor.GRAY + "Clique para abrir o menu de top " +
                "players"));

        itemStack.setItemMeta(meta);

        return itemStack;
    }

    public ItemStack itemExcavation(Player player) {
        int level = ExperienceAPI.getLevel(player,SkillType.EXCAVATION.getName());
        int posicao = 0;

        ItemStack itemStack = new ItemStack(Material.DIAMOND_SPADE);
        ItemMeta meta = itemStack.getItemMeta();

        meta.setDisplayName(ChatColor.YELLOW + "Escavação " + ChatColor.GRAY + "[" + ChatColor.GREEN + level + ChatColor.GRAY + "]");
        meta.setLore(Arrays.asList(ChatColor.GRAY + "Sua posição: " + ChatColor.GREEN + posicao + "°", "", ChatColor.GRAY + "Clique para abrir o menu de top " +
                "players"));

        itemStack.setItemMeta(meta);

        return itemStack;
    }

    public ItemStack itemFishing(Player player) {
        int level = ExperienceAPI.getLevel(player,SkillType.FISHING.getName());
        int posicao = 0;

        ItemStack itemStack = new ItemStack(Material.FISHING_ROD);
        ItemMeta meta = itemStack.getItemMeta();

        meta.setDisplayName(ChatColor.YELLOW + "Pesca " + ChatColor.GRAY + "[" + ChatColor.GREEN + level + ChatColor.GRAY + "]");
        meta.setLore(Arrays.asList(ChatColor.GRAY + "Sua posição: " + ChatColor.GREEN + posicao + "°", "", ChatColor.GRAY + "Clique para abrir o menu de top " +
                "players"));

        itemStack.setItemMeta(meta);

        return itemStack;
    }

    public ItemStack itemHerbalism(Player player) {
        int level = ExperienceAPI.getLevel(player,SkillType.HERBALISM.getName());
        int posicao = 0;

        ItemStack itemStack = new ItemStack(Material.GOLD_SPADE);
        ItemMeta meta = itemStack.getItemMeta();

        meta.setDisplayName(ChatColor.YELLOW + "Herbalismo " + ChatColor.GRAY + "[" + ChatColor.GREEN + level + ChatColor.GRAY + "]");
        meta.setLore(Arrays.asList(ChatColor.GRAY + "Sua posição: " + ChatColor.GREEN + posicao + "°", "", ChatColor.GRAY + "Clique para abrir o menu de top " +
                "players"));

        itemStack.setItemMeta(meta);

        return itemStack;
    }

    public ItemStack itemRepair(Player player) {
        int level = ExperienceAPI.getLevel(player,SkillType.REPAIR.getName());
        int posicao = 0;

        ItemStack itemStack = new ItemStack(Material.ANVIL);
        ItemMeta meta = itemStack.getItemMeta();

        meta.setDisplayName(ChatColor.YELLOW + "Reparo " + ChatColor.GRAY + "[" + ChatColor.GREEN + level + ChatColor.GRAY + "]");
        meta.setLore(Arrays.asList(ChatColor.GRAY + "Sua posição: " + ChatColor.GREEN + posicao + "°", "", ChatColor.GRAY + "Clique para abrir o menu de top " +
                "players"));

        itemStack.setItemMeta(meta);

        return itemStack;
    }

    public ItemStack itemSwords(Player player) {
        int level = ExperienceAPI.getLevel(player,SkillType.SWORDS.getName());
        int posicao = 0;

        ItemStack itemStack = new ItemStack(Material.DIAMOND_SWORD);
        ItemMeta meta = itemStack.getItemMeta();

        meta.setDisplayName(ChatColor.YELLOW + "Espadas " + ChatColor.GRAY + "[" + ChatColor.GREEN + level + ChatColor.GRAY + "]");
        meta.setLore(Arrays.asList(ChatColor.GRAY + "Sua posição: " + ChatColor.GREEN + posicao + "°", "", ChatColor.GRAY + "Clique para abrir o menu de top " +
                "players"));

        itemStack.setItemMeta(meta);

        return itemStack;
    }

    public ItemStack itemUnarmed(Player player) {
        int level = ExperienceAPI.getLevel(player,SkillType.UNARMED.getName());
        int posicao = 0;

        ItemStack itemStack = new ItemStack(Material.STICK);
        ItemMeta meta = itemStack.getItemMeta();

        meta.setDisplayName(ChatColor.YELLOW + "Desarmado " + ChatColor.GRAY + "[" + ChatColor.GREEN + level + ChatColor.GRAY + "]");
        meta.setLore(Arrays.asList(ChatColor.GRAY + "Sua posição: " + ChatColor.GREEN + posicao + "°", "", ChatColor.GRAY + "Clique para abrir o menu de top " +
                "players"));

        itemStack.setItemMeta(meta);

        return itemStack;
    }

    public ItemStack itemWoodcutting(Player player) {
        int level = ExperienceAPI.getLevel(player,SkillType.WOODCUTTING.getName());
        int posicao = 0;

        ItemStack itemStack = new ItemStack(Material.GOLD_AXE);
        ItemMeta meta = itemStack.getItemMeta();

        meta.setDisplayName(ChatColor.YELLOW + "Lenhador " + ChatColor.GRAY + "[" + ChatColor.GREEN + level + ChatColor.GRAY + "]");
        meta.setLore(Arrays.asList(ChatColor.GRAY + "Sua posição: " + ChatColor.GREEN + posicao + "°", "", ChatColor.GRAY + "Clique para abrir o menu de top " +
                "players"));

        itemStack.setItemMeta(meta);

        return itemStack;
    }

}
