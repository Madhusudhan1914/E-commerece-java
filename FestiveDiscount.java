import java.util.ArrayList;

public class FestiveDiscount extends Discount {
    private static final double DISCOUNT_PERCENTAGE = 0.10;
    
    @Override
    public double applyDiscount(double total, ArrayList<Product> products) {
        return total * (1 - DISCOUNT_PERCENTAGE);
    }
    
    @Override
    public String getDescription() {
        return "Festive Discount (10% off)";
    }
}