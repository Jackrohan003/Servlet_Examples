package lab03.inventory.model;

import java.util.ArrayList;
import java.util.HashMap;

public class Inventory{ 

    public Inventory(){ 
        //initialized with null set of inventory items
        items = new HashMap<>();
    } 

    public Item getItem(int code) throws ItemNotFound {
        //returns new object of inventory item after reading data for  
        //given item code. Throws exception if item not found.
        Item item = items.get(code);
        if (item != null)
            return item;
        else
            throw new ItemNotFound("Error: Item Not Found - " + code);
    }
    public boolean exists(int icode) {
    	return items.containsKey(icode);
    }

    public void addItem(Item item)throws ItemAlreadyExists {
        try {
            this.getItem(item.getItemCode());
            throw new ItemAlreadyExists("Error: Item aleardy exists - " + item.getItemCode());
        }
        catch(ItemNotFound e) {
            items.put(item.getItemCode(), item);
        }
    } 

    public void updateItem(Item item)throws ItemNotFound {
        this.getItem(item.getItemCode());
        items.put(item.getItemCode(), item);        
    }
        
    public void addStock(int item_code, int qty) throws ItemNotFound { 
        //adds specified qty of specified item to the inventory
        //first find the item and then add the qty to item and save it back
        Item item = this.getItem(item_code);
        item.addStock(qty);
        items.put(item.getItemCode(), item);
    } 
    public void withdrawStock(int item_code, int qty) 
                             throws ItemNotFound, InSufficientStock { 
        Item item = this.getItem(item_code);
        item.withdrawStock(qty);

    } 

    public void deleteItem(int item_code)throws ItemNotFound {
        Item itm = items.remove(item_code);
        if (itm == null)
            throw new ItemNotFound();
    }
        
    public ArrayList<Item> getAllItems() {        
        return new ArrayList<>(items.values());
    }
    
    public ArrayList<Item> itemsUnderStock() {

        ArrayList<Item> items_us = new ArrayList<>();
        for (Item itm : items.values()) {
            if ( itm.isUnderStock() ) {
                items_us.add(itm);
                //returning clone is better, though
                //requires defining clone method for Item class.
            }
        }
        return items_us;        
    }

    public double totalInventoryCost() {

        double cost = 0;
        for (Item item : items.values())
            cost += item.getCost();        
        return cost;

    }
    //Field Declarations
    private HashMap<Integer, Item> items;

}

