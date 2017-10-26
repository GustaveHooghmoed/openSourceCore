package me.michel.openDisney.Module.Modules.Studio;

import me.michel.openDisney.Core.Core;
import me.michel.openDisney.Events.EventManager;
import me.michel.openDisney.Module.Module;
import me.michel.openDisney.Module.Modules.Studio.Commands.CommandHandler;
import me.michel.openDisney.Module.Modules.Studio.Events.ExampleEvent;
import me.michel.openDisney.mySQL.MySQLManager;

public class StudioModule implements Module {

    private MySQLManager MySQLMan;
    private me.michel.openDisney.Commands.CommandFramework CommandFramework;
    private EventManager EventManager;

    @Override
    public void load() {
        this.MySQLMan = Core.getMySQLMan();
        this.CommandFramework = Core.getCommandManager();
        this.CommandFramework.registerCommands(new CommandHandler());
        this.EventManager = new EventManager();
        this.EventManager.registerEvent(new ExampleEvent());
    }

    @Override
    public void unload() {
        this.MySQLMan = null;
        this.CommandFramework = null;
        this.EventManager = null;
    }

    @Override
    public void reload() {
        this.MySQLMan.reloadMethods();
    }

    @Override
    public MySQLManager getMySQLManager() {
        return null;
    }

    public me.michel.openDisney.Commands.CommandFramework getCommandFramework() {
        return CommandFramework;
    }

    public me.michel.openDisney.Events.EventManager getEventManager() {
        return EventManager;
    }

}
