package com.rqlite.jdbc;

import java.sql.ParameterMetaData;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;

public class RqliteParameterMetaData implements ParameterMetaData {
    private RqliteResultSetMetaData meta;

    public RqliteParameterMetaData(RqliteResultSetMetaData meta) {
        this.meta = meta;
    }

    @Override
    public <T> T unwrap(Class<T> iface) throws SQLException {
        throw new SQLFeatureNotSupportedException();
    }

    @Override
    public boolean isWrapperFor(Class<?> iface) throws SQLException {
        throw new SQLFeatureNotSupportedException();
    }

    @Override
    public int getParameterCount() throws SQLException {
        return meta.param_count;
    }

    @Override
    public int isNullable(int param) throws SQLException {
        return ParameterMetaData.parameterNullableUnknown;
    }

    @Override
    public boolean isSigned(int param) throws SQLException {
        return true;
    }

    @Override
    public int getPrecision(int param) throws SQLException {
        throw new SQLFeatureNotSupportedException();
    }

    @Override
    public int getScale(int param) throws SQLException {
        throw new SQLFeatureNotSupportedException();
    }

    @Override
    public int getParameterType(int param) throws SQLException {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public String getParameterTypeName(int param) throws SQLException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public String getParameterClassName(int param) throws SQLException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public int getParameterMode(int param) throws SQLException {
        return ParameterMetaData.parameterModeIn;
    }

}

