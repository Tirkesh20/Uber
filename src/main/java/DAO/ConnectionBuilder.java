package DAO;

import java.sql.*;

import org.postgresql.Driver;

public class ConnectionBuilder {

    private static final String DB_URL = "jdbc:postgresql://localhost:5432/uber";
    private static final String USER = "postgres";
    private static final String PASS = "1234";
    public static Connection connection ;

private ConnectionBuilder() {

}
    static {
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(DB_URL, USER, PASS);
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }

    }
    public static Connection getConnection() {
        return connection;
    }

}

