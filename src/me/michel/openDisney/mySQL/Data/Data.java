package me.michel.openDisney.mySQL.Data;

import me.michel.openDisney.mySQL.Enums.DataType;
import org.bukkit.entity.Player;

public class Data {

    private Player player;
    private DataType dataType;

    public Data(int id, DataType type) {
        this.dataType = type;
    }

    public Data(int id, Player p) {
        this.dataType = DataType.PLAYER_DATA;
        this.player = p;
    }

    public DataType getDataType() {
        return dataType;
    }

    public void setDataType(DataType dataType) {
        this.dataType = dataType;
    }

    public Player getPlayer() {
        return player;
    }
}
