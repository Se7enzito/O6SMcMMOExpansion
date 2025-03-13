package org.bernardo.o6smcmmoexpansion;

import org.bernardo.o6smcmmoexpansion.stats.CommandStats;
import org.bernardo.o6smcmmoexpansion.stats.templates.StatsTemplate;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.event.HandlerList;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public final class O6SMcMMOExpansion extends JavaPlugin {

    public static O6SMcMMOExpansion m;

    private final ConsoleCommandSender console = Bukkit.getConsoleSender();
    private final PluginManager pluginManager = Bukkit.getPluginManager();

    @Override
    public void onEnable() {
        console.sendMessage(ChatColor.RED + "O6SMcMMOExpansion ligado com sucesso");

        getCommand("forcestatus").setExecutor(new CommandStats());

        pluginManager.registerEvents(new CommandStats(),this);
        pluginManager.registerEvents(new StatsTemplate(),this);

        super.onEnable();
    }

    @Override
    public void onDisable() {
        console.sendMessage(ChatColor.RED + "O6SMcMMOExpansion desligado com sucesso");

        HandlerList.unregisterAll();

        super.onDisable();
    }

    @Override
    public void onLoad() {
        m = this;

        super.onLoad();
    }

    public static O6SMcMMOExpansion getInstance() {
        return m;
    }

}
