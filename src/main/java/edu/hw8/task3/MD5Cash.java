package edu.hw8.task3;

import edu.hw8.task1.Storage;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@SuppressWarnings({"UncommentedMain", "MagicNumber", "NestedForDepth"})
public class MD5Cash {
    InputStream is;
    BufferedReader reader;

    int quantityWords;

    public MD5Cash() {
        quantityWords = 36 * 36 * 36 * 36 * 36;
        String path = "/passwords.txt";
        is = Storage.class.getResourceAsStream(path);
        try {
            reader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }

    public String cashing(String msg) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        MessageDigest m = MessageDigest.getInstance("MD5");
        m.reset();
        m.update(msg.getBytes());
        byte[] digest = m.digest();
        BigInteger bigInt = new BigInteger(1, digest);
        String hashtext = bigInt.toString(16);
// Now we need to zero pad it if you actually want the full 32 chars.
        while (hashtext.length() < 32) {
            hashtext = "0" + hashtext;
        }
        return hashtext;
    }

    public void creatPasswords() {
        String alphas = "qwertyuiopasdfghjklzxcvbnm1234567890";
        String temp = "";
        try (FileWriter writer = new FileWriter("passwords.txt", false)) {
            for (int i = 0; i < alphas.length(); i++) {
                for (int j = 0; j < alphas.length(); j++) {
                    for (int q = 0; q < alphas.length(); q++) {
                        for (int e = 0; e < alphas.length(); e++) {
                            for (int a = 0; a < alphas.length(); a++) {
                                temp = "";
                                temp += alphas.charAt(i);
                                temp += alphas.charAt(j);
                                temp += alphas.charAt(q);
                                temp += alphas.charAt(e);
                                temp += alphas.charAt(a);
                                temp += "\n";
                                writer.write(temp);

                            }

                        }
                    }
                }

            }
            writer.close();
        } catch (IOException ex) {

        }
    }

    public synchronized String nextPassword() {
        try {
            if (quantityWords != 0) {
                quantityWords--;
                return reader.readLine();
            }
            return "O";

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
