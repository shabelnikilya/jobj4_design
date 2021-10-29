package ru.job4j.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.util.StringJoiner;

public class TableEditor implements AutoCloseable {
    private Connection connection;
    private Properties properties;

    public TableEditor(Properties properties) throws SQLException, ClassNotFoundException {
        this.properties = properties;
        initConnection();
    }

    public void ValidatePropertiesFile() {
        if (properties.isEmpty() || properties.size() < 4) {
            throw new IllegalArgumentException("Incorrect file content. " +
                    "Check the contents of the file - app.properties");
        }
    }

    private void initConnection() throws ClassNotFoundException, SQLException {
        ValidatePropertiesFile();
        Class.forName(properties.getProperty("hibernate.connection.driver_class"));
        String url = properties.getProperty("hibernate.connection.url");
        String login = properties.getProperty("hibernate.connection.username");
        String password = properties.getProperty("hibernate.connection.password");
        connection = DriverManager.getConnection(url, login, password);
    }

    public void makeOperationWithTable(String operationWithTable) throws SQLException {
        try (Statement statement = connection.createStatement()) {
            statement.execute(operationWithTable);
        }
    }

    public void createTable(String tableName) throws SQLException, ClassNotFoundException {
        makeOperationWithTable(String.format(
                "create table if not exists %s();",
                tableName
        ));
    }

    public void dropTable(String tableName) throws SQLException {
        makeOperationWithTable(String.format(
                        "drop table if exists %s;",
                        tableName
        ));
    }

    public void addColumn(String tableName, String columnName, String type) throws SQLException {
        makeOperationWithTable(String.format(
                "alter table if exists %s add column %s %s;",
                        tableName,
                        columnName,
                        type
        ));
    }

    public void dropColumn(String tableName, String columnName) throws SQLException {
        makeOperationWithTable(String.format(
                        "alter table if exists %s drop column %s;",
                        tableName,
                        columnName
        ));
    }

    public void renameColumn(String tableName, String columnName, String newColumnName) throws SQLException {
        makeOperationWithTable(String.format(
                        "alter table if exists %s rename column %s to %s;",
                        tableName,
                        columnName,
                        newColumnName
        ));
    }


    public static String getTableScheme(Connection connection, String tableName) throws Exception {
        var rowSeparator = "-".repeat(30).concat(System.lineSeparator());
        var header = String.format("%-15s|%-15s%n", "NAME", "TYPE");
        var buffer = new StringJoiner(rowSeparator, rowSeparator, rowSeparator);
        buffer.add(header);
        try (var statement = connection.createStatement()) {
            var selection = statement.executeQuery(String.format(
                    "select * from %s limit 1", tableName
            ));
            var metaData = selection.getMetaData();
            for (int i = 1; i <= metaData.getColumnCount(); i++) {
                buffer.add(String.format("%-15s|%-15s%n",
                        metaData.getColumnName(i), metaData.getColumnTypeName(i))
                );
            }
        }
        return buffer.toString();
    }

    @Override
    public void close() throws Exception {
        if (connection != null) {
            connection.close();
        }
    }
}
