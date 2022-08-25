package com.rqlite.jdbc;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.sql.*;

public class RqliteJdbcTest {
    static {
        try {
            Class.forName("com.rqlite.jdbc.RqliteDriver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    Connection connection = null;

    @Before
    public void setup() throws SQLException {
        // load rqlite jdbc driver
        connection = DriverManager.getConnection("jdbc:rqlite:http://localhost:4001");
    }

    @Test
    public void testBasicQuery() throws SQLException {
        try (Statement statement = connection.createStatement()) {
            try (ResultSet resultSet = statement.executeQuery("SELECT 1 as abc")) {
                while (resultSet.next()) {
                    System.out.println(resultSet.getInt(1));
                }
            }
        }
    }

    @After
    public void teardown() throws SQLException {
        connection.close();
    }
}
