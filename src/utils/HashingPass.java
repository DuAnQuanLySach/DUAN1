package utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class HashingPass {

    public static String doHashing(String password) throws NoSuchAlgorithmException {
        MessageDigest msd = MessageDigest.getInstance("MD5");
        msd.update(password.getBytes());
        byte[] rsByteArray = msd.digest();
        StringBuilder sb = new StringBuilder();
        for (byte b : rsByteArray) {
            sb.append(String.format("%2x", b));
        }
        return sb.toString();
    }
}
