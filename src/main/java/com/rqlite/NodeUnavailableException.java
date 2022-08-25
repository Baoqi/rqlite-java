package com.rqlite;

import java.sql.SQLException;

/**
 * This exception is thrown when rqlite-java cannot connect to a rqlite node.
 **/
public class NodeUnavailableException extends SQLException {
    public NodeUnavailableException(String message){
        super(message);
    }
}