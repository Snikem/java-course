package edu.hw8.task1;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@SuppressWarnings({"UncommentedMain", "MagicNumber"})
public class Client {
    private final static Logger LOGGER = LogManager.getLogger();

    private Client() {
    }

    public static void main(String[] args) throws IOException, ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(4);
        executorService.submit(toServer("глупый"));
        executorService.submit(toServer("личности"));
        executorService.submit(toServer("оскорбления"));
        executorService.submit(toServer("интеллект"));
        executorService.shutdown();

    }

    public static Runnable toServer(String msg) {

        return new Runnable() {
            @Override
            public void run() {
                SocketChannel client = null;
                try {
                    client = SocketChannel.open(new InetSocketAddress("localhost", 18080));
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                ByteBuffer responseBuffer = ByteBuffer.allocate(256);
                ByteBuffer buffer = ByteBuffer.wrap(msg.getBytes());
                String response;
                try {
                    client.write(buffer);
                    buffer.clear();
                    client.read(responseBuffer);
                    response = new String(responseBuffer.array()).trim();
                    LOGGER.info(response);
                    buffer.clear();
                    client.close();

                } catch (IOException e) {
                    LOGGER.info(e.getMessage());
                }
            }
        };
    }

}
