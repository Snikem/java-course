package edu.hw8.task3;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@SuppressWarnings({"UncommentedMain", "MagicNumber"})
public class GuessingPassword {
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

    public String guessing(MD5Cash cash, String guessingCash) {

        String nextPass = cash.nextPassword();
        String hash;
        while (!nextPass.equals("O")) {
            try {
                hash = cashing(nextPass);
            } catch (NoSuchAlgorithmException e) {
                throw new RuntimeException(e);
            } catch (UnsupportedEncodingException e) {
                throw new RuntimeException(e);
            }

            if (guessingCash.equals(hash)) {
                return nextPass + "    " + guessingCash;
            }
            nextPass = cash.nextPassword();
        }
        return " ";
    }
}
