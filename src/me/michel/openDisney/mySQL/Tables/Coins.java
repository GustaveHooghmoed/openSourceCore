package me.michel.openDisney.mySQL.Tables;

import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class Coins {


    private Map<UUID, Integer> coins;

    public Coins() {
        this.coins = new HashMap<>();
    }

    public void addGuest(Player p, int amount) {
        coins.put(p.getUniqueId(), amount);
    }

    public void removeGuest(Player p) {
        coins.remove(p.getUniqueId());
    }

    public int getCoins(Player p) {
        return coins.get(p.getUniqueId());
    }

    public void setCoins(Player p, int amount) {
        coins.put(p.getUniqueId(), amount);
    }

    public void addCoins(Player p, int coins) {
        setCoins(p, getCoins(p) + coins);
    }

    public void removeCoins(Player p, int coins) {
        setCoins(p, getCoins(p) - coins);
    }
}
