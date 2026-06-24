import java.util.List;
import java.util.ArrayList;

interface Iterator<T> {
    boolean hasNext();
    T next();
}

class Library {
    private List<String> books;
    
    public Library() {
        books = new ArrayList<String>();
    }
    
    public void addBook(String name) {
        books.add(name);
    }
    
    public Iterator<String> getIterator() {
        return new BooksIterator();
    }
    
    private class BooksIterator implements Iterator<String> {
        private int index = 0;
        
        public boolean hasNext() {
            return index < books.size();
        }
        public String next() {
            return hasNext() ? books.get(index++) : null;
        }
        
    }
    
}

public class IteratorPattern {
    public static void main(String[] args) {
        Library library = new Library();
        
        library.addBook("Book1");
        library.addBook("Book2");
        library.addBook("Book3");
        
        Iterator<String> iterator = library.getIterator();
        while(iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
