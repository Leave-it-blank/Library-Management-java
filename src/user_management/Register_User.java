package user_management;


import Boot.boot_up;

import javax.swing.*;
import java.util.Random;

public class Register_User extends Users {
    int id, password;
    String name, email, role;

    public Register_User(int id, String name, String email, String password, String role) {
        this.id = id;
        this.name = name;
        this.email = email;
        int user_password = password.hashCode();
        this.password = user_password;
        this.role = role;  //ideally roles should be edited and added to user but for sake of my sanity im gonna keep this way.
    }

    public static void Register(Users Users_d) {
        JTextField username = new JTextField();
        JTextField role = new JTextField();
        JTextField email = new JTextField();
        JTextField password = new JPasswordField();
        Object[] message = {
                "Email:", email,
                "Username:", username,
                "Password:", password,
                "Role:", role,

        };

        int option = JOptionPane.showConfirmDialog(null, message, "Register", JOptionPane.OK_CANCEL_OPTION);

        if (option == JOptionPane.OK_OPTION) {
                Random rand = new Random();

                // Generate random integers in range 0 to 9999
                int rand_int1 = rand.nextInt(10000);
                Register_User S = new Register_User( rand_int1, username.getText().toString(), email.getText().toString(), password.getText().toString(), role.getText().toLowerCase().toString());
                Users_d.set_Userdata(S);
                System.out.println("Registration successful");
                JOptionPane.showMessageDialog(null,"Registered, Please login" );
              //  boot_up.logging_state = true;

        }
        else {
            System.out.println("Registration canceled");
            JOptionPane.showMessageDialog(null,"Registration Canceled" );
        }

    }

}
