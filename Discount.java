import java.util.ArrayList;

public abstract class Discount {
    public abstract double applyDiscount(double total, ArrayList<Product> products);
    
    public abstract String getDescription();
}