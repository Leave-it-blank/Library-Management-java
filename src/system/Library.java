package system;
import java.util.*;
public class Library implements books {

    //ArrayList<String> Books = new ArrayList<String>();
        ArrayList<ArrayList<String>> Books = new ArrayList<ArrayList<String>>();
    @Override
    public void add(String name){
       // Books.add(name);
        Books.add(new ArrayList<String>(Arrays.asList("1", "author", name)));
    }

    @Override
    public void remove(String name) {
      // Books.remove(name);
    }
    @Override
    public void view( ) {

        /* return Books.toArray(); */
        
    }
}
