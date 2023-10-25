package edu.hw2.task3.Connections.interfaces;

import edu.hw2.task3.Exceptions.ConnectionException;

public interface Connection extends AutoCloseable {
    void execute(String command) throws ConnectionException;
}
