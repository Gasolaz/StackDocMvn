package DB;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.sql.*;
import static resources.Cons.*;

public class Encoder {

    byte[] getSalt() throws NoSuchAlgorithmException {
        SecureRandom sr = SecureRandom.getInstance("SHA1PRNG");
        byte[] salt = new byte[16];
        sr.nextBytes(salt);
        return salt;
    }

    public String get_SHA_256_SecurePassword(String passwordToHash, byte[] salt) {

        String generatedPassword = null;
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            md.update(salt);
            byte[] bytes = md.digest(passwordToHash.getBytes());
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < bytes.length; i++) {
                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
            }
            generatedPassword = sb.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return generatedPassword;
    }

    //method for password insertion into the database for testing purposes
    static void insertPass(String pass) {
        Encoder enc = new Encoder();
        try {
            byte[] salt = enc.getSalt(); //get le salt
            String generatedPass = enc.get_SHA_256_SecurePassword(pass, salt); //hash da password
            Class.forName("org.sqlite.JDBC");
            Connection conn = DriverManager.getConnection("jdbc:sqlite:src/TempStackDoc.db");
            PreparedStatement ps = conn.prepareStatement("INSERT INTO " + TABLE_ADMINS + "(" +
                    ADMINS_PASSWORD + ", " + ADMINS_SALT + ") VALUES(?, ?)");
            ps.setString(1, generatedPass);
            ps.setBytes(2, salt);
            ps.execute();//insert das password
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        insertPass("test");
        insertPass("randomPass");
        insertPass("1B2I3G");
    }
}
