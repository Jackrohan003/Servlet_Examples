package lab03.inventory.model;

public class ItemAlreadyExists extends java.lang.Exception {
    public ItemAlreadyExists() {
        super("Error: Item Already Exists");
    }
    public ItemAlreadyExists(String message) {
        super(message);
    }
    
}
