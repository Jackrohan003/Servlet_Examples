package pmj.bookstore.model;

import javax.servlet.ServletRequest;

public class BookBeanUtils {

	public static BookBean fetchFromRequest(ServletRequest request) {
        String isbn = request.getParameter("isbn");
        String title = request.getParameter("title");
        double price = Double.parseDouble(request.getParameter("price"));
        int qty = Integer.parseInt(request.getParameter("stock"));		
		return new BookBean(isbn, title, price, qty);
	}

}
