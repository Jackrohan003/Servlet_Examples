package pmj.bookstore.controller.action;

import pmj.bookstore.controller.Action;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ActionShowBook implements Action {

    @Override
    public String perform(HttpServletRequest request,
            HttpServletResponse response) {
    	String isbn = request.getParameter("isbn");
    	request.setAttribute("book", BookBD.getBook(isbn));
        return "book_show.jsp";
    }
}
