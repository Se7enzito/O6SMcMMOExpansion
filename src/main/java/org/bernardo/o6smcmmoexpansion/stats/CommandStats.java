package org.bernardo.o6smcmmoexpansion.stats;

import org.bernardo.o6smcmmoexpansion.stats.templates.StatsTemplate;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

public class CommandStats implements Listener, CommandExecutor {

    private final StatsTemplate statsTemplate = new StatsTemplate();

    @EventHandler
    public void onCommand(PlayerCommandPreprocessEvent event) {
        String message = event.getMessage();
        Player player = event.getPlayer();

        if (message.startsWith("/status") || message.startsWith("/stats")) {
            event.setCancelled(true);
            statsTemplate.abrirMenuPrincipal(player);
        }
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String lbl, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;

            statsTemplate.abrirMenuPrincipal(player);
        }

        return false;
    }
}
