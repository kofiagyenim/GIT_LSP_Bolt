package org.howard.edu.lsp.oopfinal.question2;

public class PayPalPayment implements PaymentStrategy {
    // Stores the PayPal email
    private String email;

    /**
     * Initializes PayPal payment with an email address.
     * @param email User's PayPal email.
     */
    public PayPalPayment(String email) {
        this.email = email;
    }

    /**
     * Processes a payment via PayPal.
     * @param amount Amount to be paid.
     */
    @Override
    public void pay(double amount) {
        // Output payment details
        System.out.println("Amount " + amount + " transferred using PayPal: " + email);
    }
}
