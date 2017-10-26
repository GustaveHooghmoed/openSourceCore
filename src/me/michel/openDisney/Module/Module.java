package me.michel.openDisney.Module;


import me.michel.openDisney.Events.EventManager;
import me.michel.openDisney.mySQL.MySQLManager;

public interface Module {

    void load();

    void unload();

    void reload();

    MySQLManager getMySQLManager();

    EventManager getEventManager();

}