package pmj.bookstore.controller;

import java.util.Properties;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.RequestDispatcher;
import pmj.bookstore.util.ObjectCreator;

@SuppressWarnings("serial")
public class Controller extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String theAction = request.getParameter("action");

        if ( theAction == null)
            theAction = "viewcat";
        
        Action action = getActionFromConfig( theAction );

        String view = action.perform(request, response);
        
        RequestDispatcher rd = request.getRequestDispatcher(view);
        rd.forward(request, response);    
    } 
    
    private Action getActionFromConfig( String theAction ) 
            throws ServletException, IOException{
        Properties map = new Properties();
        map.load( this.getClass().getClassLoader().getResourceAsStream( ACTION_MAPPING ));
            
        String action_class = map.getProperty( 
                theAction.toLowerCase() );      
        Action action = (Action) ObjectCreator
                .createObject(action_class);       
        return action;
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    private final static String ACTION_MAPPING = "pmj/bookstore/controller/ActionMapping.properties"; 
    
}