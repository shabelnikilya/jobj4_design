package ru.job4j.jdbc;

import ru.job4j.io.Config;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDemo {
    static Config conf = new Config("app.properties");

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        conf.load();
        Class.forName(conf.value("hibernate.connection.driver_class"));
        String url = conf.value("hibernate.connection.url");
        String login = conf.value("hibernate.connection.username");
        String password = conf.value("hibernate.connection.password");
        try (Connection connection = DriverManager.getConnection(url, login, password)) {
            DatabaseMetaData metaData = connection.getMetaData();
            System.out.println(metaData.getUserName());
            System.out.println(metaData.getURL());
        }
    }
}
