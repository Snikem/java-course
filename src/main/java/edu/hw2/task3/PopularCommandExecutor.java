package edu.hw2.task3;

import edu.hw2.task3.Connections.interfaces.Connection;
import edu.hw2.task3.ConnectionsManagers.DefaultConnectionManager;
import edu.hw2.task3.ConnectionsManagers.FaultyConnectionManager;
import edu.hw2.task3.ConnectionsManagers.interfaces.ConnectionManager;
import edu.hw2.task3.Exceptions.ConnectionException;
import java.util.Random;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@SuppressWarnings({"MagicNumber", "ModifiedControlVariable", "LeftCurly"})
public final class PopularCommandExecutor {
    private final ConnectionManager manager;
    private final int maxAttempts;
    private final Random random;
    private final static Logger LOGGER = LogManager.getLogger();

    public PopularCommandExecutor(int maxAttempts) {
        this.random = new Random();
        this.manager = getManager();
        this.maxAttempts = maxAttempts;
    }

    private ConnectionManager getManager() {
        int randomInt = random.nextInt(10);
        ConnectionManager managerFun;
        if (randomInt > 5) {
            LOGGER.info("default connection man got");
            managerFun = new DefaultConnectionManager();
        } else {
            LOGGER.info("faulty connection man got");
            managerFun = new FaultyConnectionManager();
        }
        return managerFun;
    }

    public void updatePackages() {
        tryExecute("apt update && apt upgrade -y");
    }

    void tryExecute(String command) {
        ConnectionException exSave;
        Connection con = this.manager.getConnection();
        for (int i = 0; i < maxAttempts; i++) {
            try {
                con.execute(command);
                con.close();

                i = maxAttempts;
            } catch (ConnectionException ex) {
                try {
                    con.close();
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
                LOGGER.info(ex.getCause());
            } catch (Exception e) {
                throw new RuntimeException(e);
            }

        }

    }
}
