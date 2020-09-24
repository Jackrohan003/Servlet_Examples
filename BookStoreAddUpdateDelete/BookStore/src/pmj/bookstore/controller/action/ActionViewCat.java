package pmj.bookstore.controller.action;

import pmj.bookstore.controller.Action;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ActionViewCat  implements Action {

    @Override
    public String perform(HttpServletRequest request,
            HttpServletResponse response) {    	
        request.setAttribute("stock", BookBD.getStock());
        return "catalogue_view.jsp";        
    }
    
}
