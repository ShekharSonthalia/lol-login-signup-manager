package testswing;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SecurityFunctions {
   
    public static byte[] getHash(byte[] inputString)throws NoSuchAlgorithmException
    {
    MessageDigest md=MessageDigest.getInstance("SHA-256");
    md.update(inputString);
    byte[] b = md.digest();
    return b;
    }
    
    public static boolean passwordMatch(byte[] inputPassword)throws NoSuchAlgorithmException
    {
        byte[] inputPasswordHash=getHash(inputPassword);
        String master_passwd_path = System.getProperty("user.dir");
        master_passwd_path += "/master_passwd";
        Path path = Paths.get(master_passwd_path);
        boolean result=false;
        try {
                byte[] contents = Files.readAllBytes(path);
                result = java.util.Arrays.equals(contents, inputPasswordHash );
            } 
        catch (IOException ex) 
            {
                Logger.getLogger(LoginFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
        return result;
    }
    
}
