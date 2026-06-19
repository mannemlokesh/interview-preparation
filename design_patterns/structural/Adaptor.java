interface PaymentProcessor {
    void pay(String customerId, Double amount);
}

class PaytmPaymentProcessor implements PaymentProcessor {
    
    public void pay(String customerId, Double amount) {
        System.out.println("Processing amount using paytm");
    }
}

class StripeApi {
    
    public void makePayment(String id, Double amount) {
        System.out.println("Processing amount using stripe");
    }
}

class StripeAdaptor implements PaymentProcessor {
    
    private StripeApi api = new StripeApi();
    
    public void pay(String customerId, Double amount) {
        api.makePayment(customerId, amount);
    }
}

public class Adaptor {
    public static void main(String[] args) {
        PaymentProcessor process = new StripeAdaptor();
        process.pay("cust-123", 20000.32);
    }
}
