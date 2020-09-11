package lab03.inventory.model;


import java.util.ArrayList;

public class InventoryTester {

    public static void main(String[] args) {        
        Inventory inventory = new Inventory();        
        try {
            Item x;
            x = new Item(101, "USB Mouse", 10, 5, 450 ); 
            inventory.addItem(x);
            x = new Item(102, "DVD Drive", 2, 3, 2100 ); 
            inventory.addItem(x);
            x = new Item(103, "500 GB Hard Disk", 0, 3, 3500 ); 
            inventory.addItem(x);
            inventory.addStock(103, 1);
            inventory.withdrawStock(102, 3);        
        }
        catch(Exception e) {
            System.out.println( e.getMessage() );
        }
        
        //List All Items in Inventory
        System.out.println("All Items in Inventory:");
        ArrayList<Item> items = inventory.getAllItems();        
        for ( Item i : items )
            System.out.println("       " + i.getItemCode()
                    +","+i.getItemDescription()
                    +","+i.getMinQty()
                    +","+i.getStock()
                    +","+i.getCost()
            );     

        //List Items under stock
        System.out.println("Items below required Stock:");
        ArrayList<Item> ius = inventory.itemsUnderStock();        
        for ( Item i : ius )
            System.out.println("       " + i.getItemCode()
                    +","+i.getItemDescription()
                    +","+i.getMinQty()
                    +","+i.getStock()
                    +","+i.getCost()
            );     
        
    }
    
}
