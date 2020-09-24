package pmj.bookstore.controller.action;

import java.util.ArrayList;

import pmj.bookstore.model.BookBean;
import pmj.bookstore.service.BookService;
import pmj.bookstore.service.BookTO;

public class BookBD {
	
	static ArrayList<BookBean> getStock() {
	    return Cast2Bean( service.getStock() );       
	}

	static BookBean getBook(String isbn) {
	    return TO2Bean( service.getBook(isbn) );       
	}

	static void addBook(BookBean book) {		
		BookTO bookt = Bean2TO( book );
        service.addBook(bookt);
	}

	static void saveBook(BookBean book) {		
		BookTO bookt = Bean2TO( book );
        service.updateBook(bookt);
	}	
	
	static void removeBook(String isbn) {
		service.removeBook(isbn);       
	}

	private static ArrayList<BookBean> Cast2Bean(ArrayList<BookTO> bookst) {
		ArrayList<BookBean> books = new ArrayList<>();
		for(BookTO bkt : bookst) {
			books.add( TO2Bean(bkt) );
		}
		return books;
	}

	private static BookBean TO2Bean(BookTO bkt) {
		BookBean book = new BookBean(bkt.getIsbn(), bkt.getTitle(), 
				bkt.getPrice(), bkt.getStock());
		return book;
	}

	private static BookTO Bean2TO(BookBean bk) {
		BookTO book = new BookTO(bk.getIsbn(), bk.getTitle(), 
				bk.getPrice(), bk.getStock());
		return book;
	}	
	private static BookService service = BookService.getInstance();	
}
