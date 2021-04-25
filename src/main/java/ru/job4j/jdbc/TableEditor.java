package ru.job4j.jdbc;

import java.sql.*;
import java.util.Properties;

public class TableEditor implements AutoCloseable {
    private Connection connection;
    private Properties properties;

    public TableEditor(Properties properties) throws Exception {
        this.properties = properties;
        initConnection();
    }

    private static Connection getConnection() throws Exception { // создание подключения
        Class.forName("org.postgresql.Driver");
        String url = "jdbc:postgresql://localhost:5432/idea_db";
        String login = "postgres";
        String password = "password";
        return DriverManager.getConnection(url, login, password);
    }

    private void initConnection() throws Exception {
        connection = getConnection();
    }

    private void getTable(String command, String tableName) throws SQLException {
        try (Statement statement = connection.createStatement()) {
            statement.execute(command);
            System.out.println(getScheme(tableName));
        }
    }

    public void createTable(String tableName) throws SQLException {
        String sql = String.format(
                "create table" + tableName + "(%s, %s);",
                "id serial primary key",
                "name varchar(255)"
        );
        getTable(sql, tableName);
    }

    public void dropTable(String tableName) throws SQLException {
        String sql = String.format(
                "drop table %s;",
                tableName
        );
        getTable(sql, tableName);
    }

    public void addColumn(String tableName, String columnName, String type) throws SQLException {
        String sql = String.format(
                "edit table" + tableName + "%s",
                "add column" + columnName + type
        );
        getTable(sql, tableName);
    }

    public void dropColumn(String tableName, String columnName) throws SQLException {
        String sql = String.format(
                "edit table" + tableName + "%s",
                "drop column" + columnName
        );
        getTable(sql, tableName);
    }

    public void renameColumn(String tableName, String columnName, String newColumnName) throws SQLException {
        String sql = String.format(
                "edit table" + tableName + "%s",
                "edit column" + columnName + "on" + newColumnName
        );
        getTable(sql, tableName);
    }

    public String getScheme(String tableName) throws SQLException {
        StringBuilder scheme = new StringBuilder();
        DatabaseMetaData metaData = connection.getMetaData();
        try (ResultSet columns = metaData.getColumns(null, null, tableName, null)) {
            scheme.append(String.format("%-15s %-15s%n", "column", "type"));
            while (columns.next()) {
                scheme.append(String.format("%-15s %-15s%n",
                        columns.getString("COLUMN_NAME"),
                        columns.getString("TYPE_NAME")));
            }
        }
        return scheme.toString();
    }

    @Override
    public void close() throws Exception {
        if (connection != null) {
            connection.close();
        }
    }

    public static void main(String[] args) throws Exception {
        Properties properties = new Properties();
        properties.put("path", "app.properties");
        TableEditor tableEditor = new TableEditor(properties);
        tableEditor.createTable("test");
        tableEditor.renameColumn("test", "name", "first_name");
        tableEditor.addColumn("test", "last_name", "varchar(80)");
        tableEditor.dropColumn("test", "first_name");
        tableEditor.dropTable("test");
        tableEditor.close();
    }
}
