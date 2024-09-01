package utils;
import org.mindrot.jbcrypt.BCrypt;
import org.mindrot.jbcrypt.BCrypt.*;

public class passwordHashing {
    private static int saltR = 10;
    public static String hashPassword(String pass) {
        return BCrypt.hashpw(pass, BCrypt.gensalt(saltR));
    }
    public static boolean passwordsMatch(String pass, String hashed) {
        return BCrypt.checkpw(pass, hashed);
    }
}
