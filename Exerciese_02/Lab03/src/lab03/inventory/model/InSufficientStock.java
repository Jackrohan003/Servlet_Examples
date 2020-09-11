package lab03.inventory.model;

public class InSufficientStock extends java.lang.Exception{
    public InSufficientStock() {
        super("Error: Insufficient Stock");
    }
    public InSufficientStock(String message) {
        super(message);
    }    
}
