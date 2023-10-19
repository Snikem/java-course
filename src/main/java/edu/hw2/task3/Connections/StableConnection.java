package edu.hw2.task3.Connections;

import edu.hw2.task3.Connections.interfaces.Connection;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class StableConnection implements Connection {
    private final static Logger LOGGER = LogManager.getLogger();

    @Override
    public void execute(String command) {
        LOGGER.info("connection open");
        LOGGER.info("connection stable");
        LOGGER.info("execute done");

    }

    @Override
    public void close() throws Exception {
        LOGGER.info("connection close");
    }
}
