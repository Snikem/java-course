package edu.hw2.task3.ConnectionsManagers;

import edu.hw2.task3.Connections.FaultyConnection;
import edu.hw2.task3.Connections.interfaces.Connection;
import edu.hw2.task3.ConnectionsManagers.interfaces.ConnectionManager;

public class FaultyConnectionManager implements ConnectionManager {
    public FaultyConnectionManager() {
    }

    @Override
    public Connection getConnection() {
        Connection connection = new FaultyConnection();
        return connection;
    }
}
