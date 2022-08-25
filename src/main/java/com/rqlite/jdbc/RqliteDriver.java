package com.rqlite.jdbc;

import com.rqlite.Rqlite;
import com.rqlite.RqliteFactory;

import java.net.MalformedURLException;
import java.net.URL;
import java.sql.*;
import java.util.Properties;
import java.util.logging.Logger;

public class RqliteDriver implements java.sql.Driver {
    static {
        try {
            DriverManager.registerDriver(new RqliteDriver());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static final String PREFIX = "jdbc:rqlite:"; // jdbc:rqlite:http://localhost:4001

    @Override
    public Connection connect(String url, Properties info) throws SQLException {
        if (!acceptsURL(url)) {
            return null;
        }
        try {
            URL targetUrl = new URL(url.substring(PREFIX.length()));
            Rqlite rqlite = RqliteFactory.connect(
                    targetUrl.getProtocol(),
                    targetUrl.getHost(),
                    targetUrl.getPort()
            );
            return new RqliteConnection(rqlite, url);
        } catch (MalformedURLException e) {
            throw new SQLException("Wrong URL format", e);
        }
    }

    @Override
    public boolean acceptsURL(String url) throws SQLException {
        return url.startsWith(PREFIX);
    }

    @Override
    public DriverPropertyInfo[] getPropertyInfo(String url, Properties info) throws SQLException {
        return new DriverPropertyInfo[0];
    }

    @Override
    public int getMajorVersion() {
        return 1;
    }

    @Override
    public int getMinorVersion() {
        return 0;
    }

    @Override
    public boolean jdbcCompliant() {
        return true;
    }

    @Override
    public Logger getParentLogger() throws SQLFeatureNotSupportedException {
        throw new SQLFeatureNotSupportedException("no logger");
    }
}
