package org.howard.edu.lsp.oopfinal.question2;

public class ShoppingCart {
	private PaymentStrategy paymentMethod;

    public void setPaymentMethod(PaymentStrategy paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public void checkout(double amount) {
        paymentMethod.pay(amount);
    }
}