package pmj.bookstore.service;

import java.util.ArrayList;
import java.util.HashMap;

class BookServiceImpl extends BookService {
    
    public BookServiceImpl() {
        stock = new HashMap<String, Book>();
        stock.put( "1001", new Book("1001", "Database Systems", 450, 10 ));
        stock.put( "1002", new Book("1002", "Object Oriented Design and Patterns", 339,8) );
        stock.put( "1003", new Book("1003", "Core J2EE Patterns", 2250,2) );
    }
    
    public ArrayList<BookTO> getStock() {
    	ArrayList<Book> bks = new ArrayList<>(stock.values());
    	ArrayList<BookTO> books = new ArrayList<BookTO>();
        BookTO book;
        for(Book bk : bks) {
        	book = new BookTO();
        	book.setBook(bk);
            books.add(book);
        }
        return books;                
    }

    @Override
    public BookTO getBook(String isbn) {
    	Book book = stock.get( isbn );
    	BookTO bk = new BookTO();
    	bk.setBook(book);
        return bk;
    }
    
    @Override
    public void addBook(BookTO bk) {
    	Book book = bk.getBook();    	
        stock.put( book.getIsbn(), book );
    }

    @Override
    public void updateBook(BookTO bk) {
    	Book book = bk.getBook();    	
        stock.put(book.getIsbn(), book);        
    }
    
    @Override
    public void removeBook(String isbn) {
        stock.remove( isbn );
    }    

    private final HashMap<String, Book> stock;
}
