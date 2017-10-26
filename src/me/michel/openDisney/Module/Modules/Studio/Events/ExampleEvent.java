package me.michel.openDisney.Module.Modules.Studio.Events;

import me.michel.openDisney.Core.Core;
import me.michel.openDisney.Events.Interfaces.Event;
import me.michel.openDisney.Module.Module;
import me.michel.openDisney.mySQL.Data.Data;
import me.michel.openDisney.mySQL.Methods.CoinsMethod;
import me.michel.openDisney.mySQL.MySQLManager;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class ExampleEvent implements Listener, Event {

    private Module parkModule;
    private MySQLManager mySQLManager;

    @Override
    public void setup() {
        this.parkModule = Core.getModuleMan().getModule(1);
        this.mySQLManager = parkModule.getMySQLManager();
    }

    @EventHandler
    public void ExampleEvent(PlayerJoinEvent event) {
        Data data = new Data(1, event.getPlayer());
        mySQLManager.executeMethod(new CoinsMethod(), data);
    }
}
