
package user_management;

        import Boot.boot_up;

        import javax.swing.*;
        import java.util.Map;

public class Logged_in_User extends Users {


    public void login(Users Users_d) {
        JTextField username = new JTextField();
        JTextField password = new JPasswordField();
        Object[] message = {
                "Username:", username,
                "Password:", password
        };
        String db_name = "h";
        int db_pass;
        int option = JOptionPane.showConfirmDialog(null, message, "Login", JOptionPane.OK_CANCEL_OPTION);
        int passcode = password.getText().hashCode();

        boolean checkuser = Users_d.get_username(username.getText().toString());
      //  System.out.println((username.getText().toString()));
      //  System.out.println(checkuser);
       boolean passcode_check = Users_d.check_password(username.getText().toString(), passcode);
        if (option == JOptionPane.OK_OPTION) {

            if (checkuser & passcode_check) {
                System.out.println("Login successful");
                JOptionPane.showMessageDialog(null,"Logged in." );
                boot_up.logging_state = true;

            } else {
                System.out.println("login failed");
                JOptionPane.showMessageDialog(null,"Logging failed" );
            }
        } else {
            System.out.println("Login canceled");
            JOptionPane.showMessageDialog(null,"Logging Canceled" );
        }

    }

}
