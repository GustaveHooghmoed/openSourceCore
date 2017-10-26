package me.michel.openDisney.Module.Modules.Studio.Events;

import me.michel.openDisney.Events.Interfaces.Event;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class ExampleEvent implements Listener, Event {

    @Override
    public void setup() {

    }

    @EventHandler
    public void ExampleEvent(PlayerJoinEvent event) {

    }
}
