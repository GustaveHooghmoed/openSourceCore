package me.michel.openDisney.Core;

import me.michel.openDisney.Commands.CommandFramework;
import me.michel.openDisney.Module.ModuleManager;
import me.michel.openDisney.mySQL.MySQLManager;
import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

public class Core extends JavaPlugin {

    public static Plugin plugin = null;
    public static World world = null;
    public static ModuleManager moduleMan = null;
    public static MySQLManager mySQLMan = null;
    public static CommandFramework commandManager = null;
    public static Core core;

    public static Plugin getPlugin() {
        return plugin;
    }

    public static World getWorld() {
        return world;
    }

    public static ModuleManager getModuleMan() {
        return moduleMan;
    }

    public static MySQLManager getMySQLMan() {
        return mySQLMan;
    }

    public static CommandFramework getCommandManager() {
        return commandManager;
    }

    public static Core getCore() {
        return core;
    }

    @Override
    public void onEnable() {
        core = this;
        plugin = this;
        world = Bukkit.getWorld("world");
        commandManager = new CommandFramework(core);
        mySQLMan = new MySQLManager();
        moduleMan = new ModuleManager();
    }

    @Override
    public void onDisable() {
        moduleMan.unloadModules();
        mySQLMan.closeDataSource();
        moduleMan = null;
        mySQLMan = null;
        world = null;
        plugin = null;
        core = null;
    }

}
