package me.michel.openDisney.mySQL.Interfaces;

import me.michel.openDisney.mySQL.Data.Data;

public interface MySQLMethod {

    void setup();

    void execute(Data data);

    void reload();
}
