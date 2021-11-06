package system;

public interface books {  //interface class concept

  public void add_book( String author, String name);
  public int remove_book(String query);
  public Object[] get_view_as_array( );
  public void clear_books();
  public void view_books();
  public void get_book(String id);
  public int remove_book_common(String query);
  public int books_sort_by(String sort);


  //user management
  public int borrow_book(String User, String Book);

}
