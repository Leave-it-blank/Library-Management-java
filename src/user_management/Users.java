package user_management;

import java.util.*;

public  class Users implements UserData {
  public  Map<String, Register_User> Users_List = new HashMap<>();

     public void set_Userdata(Register_User U){
      //   int user_password = U.password.hashCode();
         try {
             Users_List.put(U.name, U);
             System.out.println(Users_List.get(U.name) + U.name);
             //System.out.println(Users_List);
//         for(Map.Entry<String, Register_User> entry:Users_List.entrySet()){
//             String  key=entry.getKey();
//             Register_User b=entry.getValue();
//             System.out.println(key+" Details:");
//             System.out.println(b.id+" "+b.name+" "+b.email+" "+b.password);
//         }
             System.out.println("User Registered Successfully");
         }catch (Exception e){
             System.out.println("something went Wrong~ \n\n" + e );
         }
     }
    @Override
    public void get_name(Logged_in_User L) {

    }
    public boolean get_username(String username) {
        // System.out.println(username);
        for(Map.Entry<String, Register_User> entry:Users_List.entrySet()){
              String  key=username;
              Register_User b=entry.getValue();
//             System.out.println(key+" Details:");
//             System.out.println(b.id+" "+b.name+" "+b.email+" "+b.password);
              if(b.name.equals(username.toLowerCase())){
                return true;
               }
            }
        return false;
        }

    public Boolean check_password(String username , int password) {
        for(Map.Entry<String, Register_User> entry:Users_List.entrySet()){
            String  key=username;
            Register_User b=entry.getValue();
//             System.out.println(key+" Details:");
//             System.out.println(b.id+" "+b.name+" "+b.email+" "+b.password);
            if(b.password == password){
                return true;
            }
        }
        return false;
    }
    @Override
    public void set_data(Logged_in_User L) {

    }

    @Override
    public int get_data(Register_User U) {
        for(Map.Entry<String, Register_User> entry:Users_List.entrySet()){
            String  key=entry.getKey();
            Register_User b=entry.getValue();
            System.out.println(key+" Details:");
            System.out.println(b.id+" "+b.name+" "+b.email+" "+b.password);
            return b.password;
        }
        return 0;
    }

    @Override
    public void get_borrowed_books(Logged_in_User L) {

    }
}
