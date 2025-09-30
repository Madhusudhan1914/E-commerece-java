import java.util.Scanner;

public class ShoppingCartSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Cart cart = new Cart();
        
        try {
            System.out.print("Enter number of products: ");
            int n = scanner.nextInt();
            scanner.nextLine();
            
            for (int i = 0; i < n; i++) {
                System.out.print("Enter product details (Name Price Quantity): ");
                String line = scanner.nextLine();
                String[] parts = line.split(" ");
                
                if (parts.length != 3) {
                    System.out.println("Invalid input format. Please enter: <ProductName> <Price> <Quantity>");
                    i--;
                    continue;
                }
                
                String name = parts[0];
                double price = Double.parseDouble(parts[1]);
                int quantity = Integer.parseInt(parts[2]);
                
                Product product = new Product(name, price, quantity);
                cart.addProduct(product);
            }
            
            System.out.print("Enter discount type (festive or bulk): ");
            String discountType = scanner.nextLine().toLowerCase().trim();
            
            Discount discount;
            if (discountType.equals("festive")) {
                discount = new FestiveDiscount();
            } else if (discountType.equals("bulk")) {
                discount = new BulkDiscount();
            } else {
                System.out.println("Invalid discount type. No discount applied.");
                discount = null;
            }
            
            cart.setDiscount(discount);
            cart.setPaymentMethod(new CreditCardPayment());
            
            System.out.println("\n--- Cart Details ---");
            cart.checkout();
            
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            System.out.println("Please check your input format.");
        } finally {
            scanner.close();
        }
    }
}