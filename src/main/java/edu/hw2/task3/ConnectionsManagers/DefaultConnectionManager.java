package edu.hw2.task3.ConnectionsManagers;

import edu.hw2.task3.Connections.FaultyConnection;
import edu.hw2.task3.Connections.StableConnection;
import edu.hw2.task3.Connections.interfaces.Connection;
import edu.hw2.task3.ConnectionsManagers.interfaces.ConnectionManager;
import java.util.Random;

@SuppressWarnings({"MagicNumber"})
public class DefaultConnectionManager implements ConnectionManager {
    public DefaultConnectionManager() {
    }

    @Override
    public Connection getConnection() {
        Connection connection;
        Random random = new Random();
        int randomInt = random.nextInt(10);
        if (randomInt > 7) {
            connection = new FaultyConnection();
        } else {
            connection = new StableConnection();
        }

        return connection;
    }
}
