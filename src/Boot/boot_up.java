package Boot;

import system.Library;
import user_management.Logged_in_User;
import user_management.Register_User;
import user_management.Users;

import javax.swing.*;
import java.awt.print.Book;
import java.util.Arrays;

public class boot_up {

    public static Boolean logging_state = false;

    public  void boot_up_app(){

        Library L = new Library();
        Users User_cl = new Users();
        boolean Logged_in = false;
        L.add_book( "maths_textbook" ,"sada2");
        L.add_book("eng_textbook","sada2");
        L.add_book("chem_textbook","sada1");
        L.add_book("bio_textbook","sada3");
        L.add_book("engiad_textbook","sada1");
        Register_User U = new Register_User(1, "user", "ysuke@ysuke.com", "user", "user");
        Register_User Z = new Register_User(2, "admin", "ysuke@ysuke.com", "admin", "admin");
        User_cl.set_Userdata(U);
        User_cl.set_Userdata(Z);
        boolean loop=true;

        while(loop){
            if(!logging_state){
                int choice = 1;
                String s1 = JOptionPane.showInputDialog( null,
                        " 1: Login \n 2: Register \n 3: View Books Pamplets \n 4: Exit. \n"+
                                "Enter Your choice");
                choice = Integer.parseInt(s1);
                switch (choice) {
                    case 1 -> {
                        Logged_in_User Log = new Logged_in_User();
                        Log.login(User_cl);
                    }
                    case 2 -> Register_User.Register(User_cl);
                    case 3 -> L.view_books();
                    case 4 -> loop = false;
                    default ->   JOptionPane.showMessageDialog(null,"Wrong input, Try again." );

                }
            }

            if(logging_state){
                int choice = 1;
                String s1 = JOptionPane.showInputDialog( null,
                        "1: View Books. \n 2: Add Book. \n 3: Delete Book. \n 4: Something. \n 5: Sort Book by. (id, name, author)\n " +
                                "6: Search Book.\n 7: Get all book from author.\n 8:Clear all books. \n 9:exit \n"+
                                "Enter Your choice.");
                choice = Integer.parseInt(s1);
                switch (choice){
                    case 1:  L.view_books_index();
                        break;
                    case 2:  L.add_book_interface();
                        break;
                    case 3:
                         L.remove_book_interface();
                         break;
                    case 4:
                        L.motivational_qoute();
                        break;
                    case 5:
                            L.books_sort_by_interface();
                        break;
                    case 6:  L.get_book_interface();
                        break;
                    case 7:  L.Get_all_book_from_author();
                        break;
                    case 8: L.clear_books();
                        break;
                    case 9:     JOptionPane.showMessageDialog(null,"Exiting... Thank you for using program, \n made by blank" );
                        loop = false;
                        break;
                    default:   JOptionPane.showMessageDialog(null,"Wrong input, Try again~" );
                        break;
                }

            }
        }
    }
    public static void main(String[] args) {
        System.out.println("Boot Up");
        boot_up Boot = new boot_up();

        Boot.boot_up_app();
//        System.out.println(Arrays.toString(L.get_view_as_array()));
//       // L.remove_book_common("sada2");
//        L.books_sort_by("Name");1
//        System.out.println(Arrays.toString(L.get_view_as_array()));
//
//
//        US.set_Userdata(U);
//        US.get_data(U);


    }
}
