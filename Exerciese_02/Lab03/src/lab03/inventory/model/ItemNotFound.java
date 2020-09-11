package lab03.inventory.model;

import java.util.logging.Logger;

public class ItemNotFound extends Exception {
    public ItemNotFound() {
        super("Error: Item Not Found");
    }    
    public ItemNotFound(String message) {
        super(message);
    }
}
