package lab03.inventory.model;


public class Item { 
    
    public Item (int itm_code, String itm_description, 
                                     int qty, int min_qty, double cost){ 
        this.item_code = itm_code;
        this.item_description = itm_description;
        this.qty_in_stock = qty;
        this.min_required_stock = min_qty;
        this.cost = cost;
    } 
    public Item (int code,String description,double cost ){ 
        //sets qty and min_qty to zero
        this.item_code = code;
        this.item_description = description;
        this.qty_in_stock = 0;
        this.min_required_stock = 0;
        this.cost = cost;
    } 
    public int getItemCode() {
        return item_code;
    }
    public String getItemDescription() {
        return item_description;
    }
    public double getCost(){ 
        return cost;
    } 
    void setCost(double cost){
        this.cost = cost;
    }
    public int getStock(){ 
        return qty_in_stock;
    } 
    public int getMinQty() {
        return min_required_stock;
    }
    public boolean isUnderStock(){ 
        return qty_in_stock < min_required_stock;    
    } 
    public void addStock(int qty){ 
        //increases the stock by given amount
        qty_in_stock += qty;
    }
    public void withdrawStock(int qty) throws InSufficientStock { 
        //decreases the stock by given amount
        if ( qty <= qty_in_stock )
            qty_in_stock -= qty;
        else
            throw new InSufficientStock("Error: Item withraw Isnsufficient balance - " + item_code);
    } 

    //Field Declarations
    private int item_code; 
    private String item_description;
    private int qty_in_stock;
    private int min_required_stock;
    private double cost;
}
