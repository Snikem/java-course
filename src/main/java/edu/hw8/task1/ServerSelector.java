package edu.hw8.task1;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.StandardCharsets;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@SuppressWarnings({"UncommentedMain", "MagicNumber"})
public class ServerSelector {
    static Storage storage;
    static ExecutorService executorService;

    private ServerSelector() {
    }

    public static void main(String[] args) throws IOException {
        storage = new Storage();
        executorService = Executors.newFixedThreadPool(4);
        Selector selector = Selector.open();
        ServerSocketChannel serverSocket = ServerSocketChannel.open();
        serverSocket.bind(new InetSocketAddress("localhost", 18080));
        serverSocket.configureBlocking(false);
        serverSocket.register(selector, SelectionKey.OP_ACCEPT);

        while (true) {
            selector.select();
            Set<SelectionKey> selectionKeys = selector.selectedKeys();
            Iterator<SelectionKey> iter = selectionKeys.iterator();
            while (iter.hasNext()) {
                SelectionKey key = iter.next();

                if (key.isAcceptable()) {
                    register(selector, serverSocket);

                }

                if (key.isReadable()) {

                    executorService.submit(answerWithEcho(key));
                }
                iter.remove();
            }
        }

    }

    private static void register(Selector selector, ServerSocketChannel serverChannel) throws IOException {
        SocketChannel client = serverChannel.accept();
        client.configureBlocking(false);
        client.register(selector, SelectionKey.OP_READ);
    }

    private static Runnable answerWithEcho(SelectionKey key) {

        return new Runnable() {
            @Override
            public void run() {
                SocketChannel client = (SocketChannel) key.channel();
                String phrase;
                ByteBuffer buffer = ByteBuffer.allocate(256);
                int r = 0;
                try {
                    r = client.read(buffer);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                if (r == -1) {
                    try {
                        client.close();
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                } else {
                    buffer.flip();
                    phrase = storage.getPhrase(StandardCharsets.UTF_8.decode(buffer).toString());
                    ByteBuffer response = ByteBuffer.wrap(phrase.getBytes());
                    try {
                        client.write(response);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                    buffer.clear();
                }
            }
        };
    }
}
