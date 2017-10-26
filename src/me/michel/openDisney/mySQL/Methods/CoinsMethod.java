package me.michel.openDisney.mySQL.Methods;

import me.michel.openDisney.Core.Core;
import me.michel.openDisney.mySQL.Data.Data;
import me.michel.openDisney.mySQL.Enums.DataType;
import me.michel.openDisney.mySQL.Fields.MySQLFields;
import me.michel.openDisney.mySQL.Interfaces.MySQLMethod;
import me.michel.openDisney.mySQL.Tables.Coins;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CoinsMethod implements MySQLMethod {

    private Coins coins;

    @Override
    public void setup() {
        this.coins = new Coins();
    }

    public void execute(Data data) {
        Bukkit.getScheduler().runTaskAsynchronously(Core.getPlugin(), new Runnable() {
            @Override
            public void run() {
                if (data.getDataType() == DataType.PLAYER_DATA) {
                    try (Connection connection = Core.getMySQLMan().getDataSource().getConnection()) {
                        Player p = data.getPlayer();
                        PreparedStatement insert = connection.prepareStatement(MySQLFields.COINS_INSERT);
                        PreparedStatement select = connection.prepareStatement(MySQLFields.COINS_SELECT);
                        insert.setString(1, p.getUniqueId().toString());
                        insert.setString(2, p.getName());
                        insert.setInt(3, 0);
                        insert.setString(4, p.getName());
                        insert.execute();

                        select.setString(1, p.getUniqueId().toString());
                        ResultSet result = select.executeQuery();
                        if (result.next())
                            coins.addGuest(p, result.getInt("coins"));
                        result.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
    }

    @Override
    public void reload() {

    }


}
