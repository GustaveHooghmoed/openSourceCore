package me.michel.openDisney.Module.Modules.Essentials.Commands;

import me.michel.openDisney.Commands.Annonantions.Command;
import me.michel.openDisney.Commands.Objects.CommandArgs;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class CommandHandler {

    @Command(name = "gamemode", permission = "OD.gamemode", inGameOnly = true, aliases = "gm")
    public void Gamemode(CommandArgs command) {
        Player p = command.getPlayer();
        if (command.getArgs().length == 0) {
            // TODO => Message
            p.sendMessage("0,1,2,3 excepted message");
        } else if (command.getArgs().length > 0) {
            if (command.getArgs()[0].equalsIgnoreCase("0")) {
                p.setGameMode(GameMode.SURVIVAL);
            } else if (command.getArgs()[0].equalsIgnoreCase("1")) {
                p.setGameMode(GameMode.CREATIVE);
            } else if (command.getArgs()[0].equalsIgnoreCase("2")) {
                p.setGameMode(GameMode.ADVENTURE);
            } else if (command.getArgs()[0].equalsIgnoreCase("3")) {
                p.setGameMode(GameMode.SPECTATOR);
            }
        }
    }

    @Command(name = "nightvision", permission = "OD.nightvision", inGameOnly = true, aliases = "nv")
    public void NightVision(CommandArgs command) {
        Player p = command.getPlayer();
        if (command.getArgs().length == 0) {
            p.addPotionEffect(new PotionEffect(PotionEffectType.NIGHT_VISION, 100000, 16));
        } else {
            Player target = Bukkit.getPlayer(command.getArgs()[0]);
            target.addPotionEffect(new PotionEffect(PotionEffectType.NIGHT_VISION, 100000, 16));
        }
    }
}
