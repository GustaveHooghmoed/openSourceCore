package me.michel.openDisney.mySQL;

import com.zaxxer.hikari.HikariDataSource;
import me.michel.openDisney.mySQL.Data.Data;
import me.michel.openDisney.mySQL.Interfaces.MySQLMethod;
import me.michel.openDisney.mySQL.Methods.CoinsMethod;

import java.util.ArrayList;

public class MySQLManager {

    private HikariDataSource dataSource;
    private ArrayList<MySQLMethod> methodes;

    public MySQLManager() {
        dataSource = new HikariDataSource();
        dataSource.setDataSourceClassName("com.mysql.jdbc.jdbc2.optional.MysqlDataSource");
        dataSource.addDataSourceProperty("serverName", "localhost");
        dataSource.addDataSourceProperty("port", 3307);
        dataSource.addDataSourceProperty("databaseName", "openDisney");
        dataSource.addDataSourceProperty("user", "root");
        dataSource.addDataSourceProperty("password", "usbw");
        methodes = new ArrayList<>();
        registerMethods();
        loadMethods();
    }

    private void registerMethods() {
        methodes.add(new CoinsMethod());
    }

    public HikariDataSource getDataSource() {
        return dataSource;
    }

    public void loadMethods() {
        for (MySQLMethod mySQLMethod : methodes) {
            mySQLMethod.setup();
        }
    }

    public void executeMethod(MySQLMethod mySQLMethod, Data data) {
        getMethod(0).execute(data);
    }

    private MySQLMethod getMethod(int i) {
        return methodes.get(i);
    }

    public void closeDataSource() {
        if (dataSource != null)
            dataSource.close();
    }


    public void reloadMethods() {
        for (MySQLMethod method : methodes) {
            method.reload();
        }
    }
}
