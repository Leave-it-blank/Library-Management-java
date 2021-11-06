package user_management;

public interface UserData {
    public void get_name(Logged_in_User U);
    public void set_data (Logged_in_User U);
    public int get_data(Register_User U);
    public void get_borrowed_books(Logged_in_User U);
}
