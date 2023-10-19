package edu.hw2.task3.Connections;

import edu.hw2.task3.Connections.interfaces.Connection;
import edu.hw2.task3.Exceptions.ConnectionException;
import java.util.Random;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@SuppressWarnings({"MagicNumber"})
public class FaultyConnection implements Connection {

    private final static Logger LOGGER = LogManager.getLogger();

    @Override
    public void execute(String command) throws ConnectionException {
        LOGGER.info("connection open");
        LOGGER.info("connection faulty");
        Random random = new Random();
        int randomInt = random.nextInt(10);
        if (randomInt > 7) {
            LOGGER.info("execute done");
        } else {
            throw new ConnectionException("execute fault");
        }

    }

    @Override
    public void close() throws Exception {
        LOGGER.info("connection close");
    }
}
