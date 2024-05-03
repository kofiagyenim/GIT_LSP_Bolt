package org.howard.edu.lsp.oopfinal.question2;

public class CreditCardPayment implements PaymentStrategy {
    private String cardNum;

    public CreditCardPayment(String cardNum) {
        this.cardNum = cardNum;
    }

    @Override
    public void pay(double amount) {
        System.out.println("Amount " + amount + " charged to credit card: " + cardNum);
    }
}
