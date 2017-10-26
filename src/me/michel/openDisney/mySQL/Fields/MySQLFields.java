package me.michel.openDisney.mySQL.Fields;

public class MySQLFields {

    public static final String COINS_INSERT = "INSERT INTO Coins VALUES(?,?,?) ON DUPLICATE KEY UPDATE name=?";
    public static final String COINS_SELECT = "SELECT coins FROM Coins WHERE uuid=?";
    public static final String COINS_SAVE = "UPDATE Coins SET coins=? WHERE uuid=?";

}
