package me.michel.openDisney.Module.Modules.Essentials;

import me.michel.openDisney.Core.Core;
import me.michel.openDisney.Events.EventManager;
import me.michel.openDisney.Module.Module;
import me.michel.openDisney.Module.Modules.Essentials.Commands.CommandHandler;
import me.michel.openDisney.mySQL.MySQLManager;

public class EssentialsModule
        implements Module {

    private MySQLManager MySQLMan;
    private me.michel.openDisney.Commands.CommandFramework CommandFramework;
    private me.michel.openDisney.Events.EventManager EventManager;

    @Override
    public void load() {
        this.MySQLMan = Core.getMySQLMan();
        this.CommandFramework = Core.getCommandManager();
        this.CommandFramework.registerCommands(new CommandHandler());
        this.EventManager = new EventManager();
    }

    @Override
    public void unload() {
        this.MySQLMan = null;
    }

    @Override
    public void reload() {
        this.MySQLMan.reloadMethods();
    }

    @Override
    public MySQLManager getMySQLManager() {
        return this.MySQLMan;
    }

    public me.michel.openDisney.Commands.CommandFramework getCommandFramework() {
        return CommandFramework;
    }

    public me.michel.openDisney.Events.EventManager getEventManager() {
        return EventManager;
    }
}
