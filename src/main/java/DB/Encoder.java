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
    public static void insertPass(long id, String pass) {
        Encoder enc = new Encoder();
        try {
            byte[] salt = enc.getSalt(); //get le salt
            String generatedPass = enc.get_SHA_256_SecurePassword(pass, salt); //hash da password
            Class.forName("org.sqlite.JDBC");
            Connection conn = DriverManager.getConnection("jdbc:sqlite:src/TempStackDoc.db");
            PreparedStatement ps = conn.prepareStatement("INSERT INTO " + TABLE_ADMINS + "(" + ADMINS_ID + ", " +
                    ADMINS_PASSWORD + ", " + ADMINS_SALT + ") VALUES(?, ?, ?)");
            ps.setLong(1, id);
            ps.setString(2, generatedPass);
            ps.setBytes(3, salt);
            ps.execute();//insert das password
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

//    public static boolean checkIfExists(String pass) {
//
//        try {
//            Encoder enc = new Encoder();
//            Class.forName("org.sqlite.JDBC");
//            Connection conn = DriverManager.getConnection("jdbc:sqlite:src/TempStackDoc.db");
//            Statement statement = conn.createStatement();
//            ResultSet rs = statement.executeQuery("SELECT * FROM " + TABLE_ADMINS); //select admin table
//            while (rs.next()){
//                byte[] salt = rs.getBytes(ADMINS_SALT); //taking salt from database's row
//                String hashedEnteredPass = enc.get_SHA_256_SecurePassword(pass, salt); //hashing entered password
//                String hashedPassInDB = rs.getString(ADMINS_PASSWORD); //getting already existing password from the database
//                if(hashedEnteredPass.equals(hashedPassInDB)){ //if hashed entered password is equal to already existing password
//                    return true;
//                }
//            }
//        } catch (SQLException | ClassNotFoundException e){
//            e.printStackTrace();
//        }
//        return false;
//    }

    public static void main(String[] args) {
//        insertPass(1,"trololo");
//        insertPass(2,"420blazeit");
//        insertPass(3,"bushdid911");
//        System.out.println(checkIfExists("trololo")); //true
//        System.out.println(checkIfExists("420blazeit")); //true
//        System.out.println(checkIfExists("bushdid911")); //true
//        System.out.println(checkIfExists("imnotgaybut20dollaris20dollar")); //false
    }
}
