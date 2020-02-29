package testswing;

import java.io.File;

public class TestSwing {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        LoginFrame fr=new LoginFrame();
        NewUser nu=new NewUser();
        if(!fileCheck())
        {
            nu.setVisible(true);
        }
        else
        {
        fr.setVisible(true);
        }
    }
        
        private static boolean fileCheck() {
        String master_passwd_path = System.getProperty("user.dir");
        master_passwd_path += "/master_passwd";
        File master_passwd = new File(master_passwd_path);

        return (master_passwd.exists());
    }
    
}
