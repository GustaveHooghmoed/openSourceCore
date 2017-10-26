package me.michel.openDisney.Events;

import me.michel.openDisney.Core.Core;
import me.michel.openDisney.Events.Interfaces.Event;
import org.bukkit.Bukkit;

import java.util.ArrayList;

public class EventManager {

    private ArrayList<Event> events = new ArrayList<>();

    public EventManager() {

    }

    public void registerEvent(Event e) {
        events.add(e);
        Bukkit.getPluginManager().registerEvents(e, Core.getPlugin());
    }

    public void unregisterEvent(Event e) {
        events.remove(e);
    }
}
