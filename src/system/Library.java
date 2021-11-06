package system;
import Boot.boot_up;
import user_management.Register_User;

import javax.swing.*;
import java.awt.print.Book;
import java.util.*;
import java.util.Iterator;
public class Library implements books {

    //ArrayList<String> Books = new ArrayList<String>();
  ArrayList<ArrayList<String>> Books = new ArrayList<ArrayList<String>>();
  ArrayList<ArrayList<String>> Borrowed_Books = new ArrayList<ArrayList<String>>();
    @Override
    public void add_book(String name, String author){
        Random rand = new Random();

        // Generate random integers in range 0 to 9999
        int rand_int1 = rand.nextInt(10000);
        String id = String.valueOf(rand_int1);

        // Books.add(name);
        String is_borrowed = "false";
       // Books.add(new ArrayList<String>(Arrays.asList(id,name, author, "Borrowed")));
        Books.add(new ArrayList<String>(Arrays.asList(id,name.toLowerCase(), author.toLowerCase(), is_borrowed)));
    }

    public void add_book_interface(){
        JTextField name = new JTextField();
        JTextField author = new JTextField();


        Object[] message = {

                "Book Name:", name,
                "Author:", author,


        };

        int option = JOptionPane.showConfirmDialog(null, message, "Add New Book", JOptionPane.OK_CANCEL_OPTION);

        if (option == JOptionPane.OK_OPTION) {
            add_book( name.getText().toString(),author.getText().toString());
            System.out.println("Book added.");
            JOptionPane.showMessageDialog(null,"Book added." );
            boot_up.logging_state = true;

        }
        else {
            System.out.println("Failed to add book, cancelled");
            JOptionPane.showMessageDialog(null,"Failed to add book, cancelled" );
        }
    }

    @Override
    public int remove_book(String query) {  //removes only first book with matching query
       boolean book_deleted = false;
        for (int i = 0; Books.size() > i; i++) {
     /*     if(Books.get(i).get(0).equals(query)){
              System.out.println("Book has been removed, Details-> "+ Books.get(i));
              Books.remove(i);
              return 0;
          }*/
          if(Books.get(i).get(1).equals(query)){
                System.out.println("Book has been removed, Details-> "+ Books.get(i));
               JOptionPane.showMessageDialog(null,"Books Deleted. "+ Books.get(i).get(1) );
                Books.remove(i);
              book_deleted = true;
                return 0;
            }
          if(Books.get(i).get(2).equals(query)){
              System.out.println("Book has been removed, Details-> "+ Books.get(i));
              JOptionPane.showMessageDialog(null,"Books Deleted. " + Books.get(i).get(1));
                Books.remove(i);
              book_deleted = true;
                return 0;
            }
        }
        JOptionPane.showMessageDialog(null,"Book not found!");
        System.out.println("Book not found.");
        return 0;

    }
    public void remove_book_interface(){
        JTextField name = new JTextField();

        Object[] message = {
                "Enter Key[name or author]:", name,
        };

        int option = JOptionPane.showConfirmDialog(null, message, "Delete the Book", JOptionPane.OK_CANCEL_OPTION);
        if (option == JOptionPane.OK_OPTION) {
            remove_book(name.getText().toLowerCase());

        }
        else {
            System.out.println("Failed to add book, cancelled");
            JOptionPane.showMessageDialog(null,"Failed to add book, cancelled" );
        }
    }
    @Override
    public Object[] get_view_as_array( ) {
        /* return Books.toArray(); */
        return Books.toArray();

    }

    @Override
    public void clear_books() {
        Books.clear();
    }

    @Override
    public void view_books() {
       String message = "";
        for (int i = 0; i < Books.size(); i++) {
            System.out.println(Books.get(i));
            message = message + "Book ID:"+ Books.get(i).get(0)+ " Book Name:"+ Books.get(i).get(1)+ "\n";
        }
        JOptionPane.showMessageDialog(null, message );
    }
    public void view_books_index() {
        String message = "";
        for (int i = 0; i < Books.size(); i++) {
            System.out.println(Books.get(i));
            message = message +  "Book Name:"+ Books.get(i).get(1)+" by "+ Books.get(i).get(2) +"\n";
        }
        JOptionPane.showMessageDialog(null, message );
    }

    @Override
    public void get_book(String query) {
        String msg = "";
        for (int i = 0; Books.size() > i; i++) {
//            if(Books.get(i).get(0).equals(query)){
//                System.out.println(Books.get(i));
//               JOptionPane.showMessageDialog(null, "Book id "+ Books.get(i).get(0) +" Book name"+Books.get(i).get(1) +" By "+ Books.get(i).get(2));
//            }
            if(Books.get(i).get(1).equals(query)){
                System.out.println(Books.get(i));
              msg = msg +  "Book id "+ Books.get(i).get(0) +" Book name"+Books.get(i).get(1) +" By "+ Books.get(i).get(2)+ "\n ";
            }
            if(Books.get(i).get(2).equals(query)){
                System.out.println(Books.get(i));
                msg = msg +  "Book id "+ Books.get(i).get(0) +" Book name"+Books.get(i).get(1) +" By "+ Books.get(i).get(2)+ "\n ";
            }
        }
        JOptionPane.showMessageDialog(null, msg  );
    }
    public void get_book_interface() {
        JTextField name = new JTextField();

        Object[] message = {
                "Enter Key[name or author]:", name,
        };

        int option = JOptionPane.showConfirmDialog(null, message, "Search Book", JOptionPane.OK_CANCEL_OPTION);
        if (option == JOptionPane.OK_OPTION) {
            get_book(name.getText().toLowerCase());
            System.out.println("Book found");
           // JOptionPane.showMessageDialog(null,"Books Sorted." );
        }
        else {
            System.out.println("Book not found");
            JOptionPane.showMessageDialog(null,"Book is not available" );
        }
    }

    @Override
    public int remove_book_common(String query) {//removes all books with matching query // itrator and arraylist
        Iterator<ArrayList<String>> it = Books.iterator();
        int i=0;
        boolean book_found = false;

        while (it.hasNext()) {
  /*            if (Books.get(i).get(0).equals(query)) {
                System.out.println("Book has been removed, Details-> " + Books.get(i));
                Books.remove(i);
                i--;
                book_found = true;
            }*/

            if (Books.get(i).get(1).equals(query)) {
                System.out.println("Book has been removed, Details-> " + Books.get(i));
                Books.remove(i);
                i--;
                book_found = true;
                it.next();
                return 0;
            }
            if (Books.get(i).get(2).equals(query)) {
                System.out.println("Book has been removed, Details-> " + Books.get(i));
                Books.remove(i);
                i--;
                book_found = true;
                it.next();
                return 0;

            }
            i++;

        }
        if(!book_found){
            System.out.println("Book not found.");
        }
        return 0;
    }
    public void remove_book_common_interface(){
        JTextField name1 = new JTextField();

        Object[] message = {
                "Enter Key[name or author]:", name1,
        };

        int option = JOptionPane.showConfirmDialog(null, message, "Delete the Book[All book with key will be deleted]", JOptionPane.OK_CANCEL_OPTION);
        if (option == JOptionPane.OK_OPTION) {
            remove_book_common(name1.getText().toLowerCase());
            JOptionPane.showMessageDialog(null,"Books Deleted." );
        }
        else {
            System.out.println("Failed to add book, cancelled");
            JOptionPane.showMessageDialog(null,"Failed to add book, cancelled" );
        }
    }
    @Override
    public int books_sort_by(String sortby) { //collection and sorting, lamda function
      String sortn=  sortby.toLowerCase();
       try{ if(sortn.equals("name")){
            Collections.sort(Books, (o1, o2) -> o1.get(1).compareTo(o2.get(1)));
            return 0;
        }
        if(sortn.equals("id")){
            Collections.sort(Books, (o1, o2) -> o1.get(0).compareTo(o2.get(0)));
            return 0;
        }
        if(sortn.equals("author")){
            Collections.sort(Books, (o1, o2) -> o1.get(2).compareTo(o2.get(2)));
            return 0;
        }
            JOptionPane.showMessageDialog(null, "Books are sorted.");

           return 0;
       }catch(Exception e) {
           JOptionPane.showMessageDialog(null, "You can sort books by: id,name, author only.");
           System.out.println("You can sort books by: id,name, author");
           return 0;
       }
    }
    public void books_sort_by_interface(){
        JTextField name1 = new JTextField();

        Object[] message = {
                "Enter Key[name or author]:", name1,
        };

        int option = JOptionPane.showConfirmDialog(null, message, "Sort Books", JOptionPane.OK_CANCEL_OPTION);
        if (option == JOptionPane.OK_OPTION) {
            books_sort_by(name1.getText());
          JOptionPane.showMessageDialog(null,"Books Sorted." );
        }
        else {
            System.out.println("failed to sort.");
            JOptionPane.showMessageDialog(null,"Failed to sort books." );
        }
    }

    @Override
    public int borrow_book(String User, String Book) {  //borrow the book , we are using user id and book id to make a pivot table like structure

        return 0;
    }
    public void Get_all_book_from_author(){
        JTextField name = new JTextField();

        Object[] message = {
                "Enter Author Name:", name,
        };

        int option = JOptionPane.showConfirmDialog(null, message, "Find books by this author", JOptionPane.OK_CANCEL_OPTION);
        if (option == JOptionPane.OK_OPTION) {

            String message_show =" Author has following books \n";
            boolean book_found = false;
            for (int n = 0; Books.size() >n; n++) {

                if (Books.get(n).get(2).equals(name.getText().toLowerCase())) {
                    message_show = message_show + "Book Name:" + Books.get(n).get(1)+ "\n ";
                    book_found = true;
                }
                n++;
            }
            if(book_found){
                JOptionPane.showMessageDialog(null,message_show );
            }
            if(!book_found){
                JOptionPane.showMessageDialog(null,"Failed to find any books from this author." );
            }
        }
        else {
            System.out.println("failed to sort.");
            JOptionPane.showMessageDialog(null,"Failed to sort books." );
        }




    }

    public void motivational_qoute(){
        System.out.println("well good luck, thats all i got.");
    }

}
