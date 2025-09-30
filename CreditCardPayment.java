public class CreditCardPayment implements Payment {
    @Override
    public void pay(double amount) {
        System.out.println("Payment of $" + String.format("%.2f", amount) + " processed via Credit Card.");
    }
}