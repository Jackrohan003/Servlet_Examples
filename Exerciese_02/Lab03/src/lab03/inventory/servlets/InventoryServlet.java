package lab03.inventory.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lab03.inventory.model.InSufficientStock;
import lab03.inventory.model.Inventory;
import lab03.inventory.model.Item;
import lab03.inventory.model.ItemAlreadyExists;
import lab03.inventory.model.ItemNotFound;


@WebServlet("/inventory")
public class InventoryServlet extends HttpServlet {
	
	
	Inventory inventory;
    public InventoryServlet() {
        super();
        inventory=new Inventory();
        try {
        	 inventory.addItem( new Item(101, "USB Mouse", 10, 5, 450 ) );
        	 inventory.addItem( new Item(102, "DVD Drive", 2, 3, 2100 ) );
        	 inventory.addItem( new Item(103, "500 GB Hard Disk", 0, 3, 3500 ) );
        	 }
        	 catch(ItemAlreadyExists e) {
        		 
        	 }
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    private void processRequests(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String action = request.getParameter("action");
        
        if ( action.equalsIgnoreCase("listitems")) {
            out.println("<h2>All Items in Inventory:</h2>");
            ArrayList<Item> items = inventory.getAllItems();        
            for ( Item i : items )
                out.println("<p>       " + i.getItemCode()
                    +","+i.getItemDescription()
                    +","+i.getMinQty()
                    +","+i.getStock()
                    +","+i.getCost()
                    +"</p>"
                );    
        }
        else if ( action.equalsIgnoreCase("getitem")) {
            
            int icode = Integer.parseInt(request.getParameter("code"));
            try {
                Item item = inventory.getItem(icode);            
                out.println("<h2>Requested Item details</h2>");
                out.println("<p>Item-code: " + icode + "</p>");
                out.println("<p>item-description: " + item.getItemDescription() + "</p>");
                out.println("<p>Item stock: " + item.getStock() + "</p>");
                out.println("<p>Item required min qty: " + item.getMinQty() + "</p>");
                out.println("<p>item-cost: " + item.getCost() + "</p>");                
            }
            catch(ItemNotFound e) {
                out.println("<h2>There is no item for given item code</h2>");
            }
        }
        else if ( action.equalsIgnoreCase("addstock")) {
            
            int icode = Integer.parseInt(request.getParameter("code"));
            int iqty = Integer.parseInt(request.getParameter("qty"));
            try {
                inventory.addStock(icode, iqty);
                out.println("<h2>Stock Added Successfully!</h2>");
            }
            catch(ItemNotFound e) {
                out.println("<h2>There is no item for given item code</h2>");
            }
        }
        else if ( action.equalsIgnoreCase("withdraw")) {
            
            int icode = Integer.parseInt(request.getParameter("code"));
            int iqty = Integer.parseInt(request.getParameter("qty"));
            try {
                inventory.withdrawStock(icode, iqty);
                out.println("<h2>Stock Withdrawn Successfully!</h2>");
            }
            catch(ItemNotFound e) {
                out.println("<h2>Error: There is no item for given item code</h2>");
            }
            catch(InSufficientStock e) {
                out.println("<h2>Error: There is not enough stock for required item</h2>");
            }
        }
        else if (action.equalsIgnoreCase("additem")) {
            
            int icode = Integer.parseInt(request.getParameter("code"));
            String descr = request.getParameter("description");
            int stock = Integer.parseInt(request.getParameter("stock"));
            int minstock = Integer.parseInt(request.getParameter("minstock"));
            double cost = Double.parseDouble(request.getParameter("cost"));
            try {
                inventory.addItem( new Item(icode, descr, stock, minstock, cost) );
                out.println("<h2>Item " + icode + " Successfully added!</h2>");
            }
            catch(ItemAlreadyExists e) {
                out.println("<h2>Error: Item " + icode + " already exists </h2>");
            }
        }
        else if(action.equalsIgnoreCase("checkItem")) {
        	
        	 int icode = Integer.parseInt(request.getParameter("code"));
        	 
        	 
        	 if(inventory.exists(icode)) { //new method added to check availability
        		 out.write("Exists");
        	 }
        	 else {
        		 out.write("Success");
        	 }
        }
        
        
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		processRequests(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		processRequests(request,response);
	}

}
	