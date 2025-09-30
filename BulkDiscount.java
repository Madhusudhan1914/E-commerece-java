import java.util.ArrayList;

public class BulkDiscount extends Discount {
    private static final double DISCOUNT_PERCENTAGE = 0.20;
    private static final int BULK_QUANTITY_THRESHOLD = 5;
    
    @Override
    public double applyDiscount(double total, ArrayList<Product> products) {
        boolean qualifiesForBulkDiscount = false;
        for (Product product : products) {
            if (product.getQuantity() > BULK_QUANTITY_THRESHOLD) {
                qualifiesForBulkDiscount = true;
                break;
            }
        }
        
        if (qualifiesForBulkDiscount) {
            return total * (1 - DISCOUNT_PERCENTAGE);
        }
        return total;
    }
    
    @Override
    public String getDescription() {
        return "Bulk Discount (20% off if quantity > 5)";
    }
}