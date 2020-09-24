package pmj.bookstore.service;

import java.util.ArrayList;

public abstract class BookService {
       
    public abstract ArrayList<BookTO> getStock();
    public abstract BookTO getBook(String isbn);
    public abstract void addBook(BookTO bk);
    public abstract void updateBook(BookTO bk);
    public abstract void removeBook(String isbn);

    public static BookService getInstance() {
    	return new BookServiceImpl();
    }

}
