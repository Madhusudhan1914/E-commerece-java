import java.util.ArrayList;

public class Cart {
    private ArrayList<Product> products;
    private Discount discount;
    private Payment paymentMethod;
    
    public Cart() {
        this.products = new ArrayList<>();
    }
    
    public void addProduct(Product product) {
        products.add(product);
    }
    
    public void setDiscount(Discount discount) {
        this.discount = discount;
    }
    
    public void setPaymentMethod(Payment paymentMethod) {
        this.paymentMethod = paymentMethod;
    }
    
    public double calculateTotal() {
        double total = 0;
        for (Product product : products) {
            total += product.getTotalPrice();
        }
        return total;
    }
    
    public double calculateFinalAmount() {
        double total = calculateTotal();
        if (discount != null) {
            return discount.applyDiscount(total, products);
        }
        return total;
    }
    
    public void checkout() {
        for (Product product : products) {
            System.out.println(product.toString());
        }
        
        double finalAmount = calculateFinalAmount();
        System.out.println("Total Amount Payable: " + String.format("%.2f", finalAmount));
        
        if (paymentMethod != null) {
            paymentMethod.pay(finalAmount);
        }
    }
    
    public ArrayList<Product> getProducts() {
        return products;
    }
}