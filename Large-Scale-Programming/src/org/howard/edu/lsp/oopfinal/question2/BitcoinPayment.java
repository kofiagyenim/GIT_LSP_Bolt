package org.howard.edu.lsp.oopfinal.question2;

public class BitcoinPayment implements PaymentStrategy {
    // Bitcoin wallet address
    private String btcAddress;

    /**
     * Constructor to initialize the Bitcoin wallet address.
     * @param btcAddress Wallet address for Bitcoin payments.
     */
    public BitcoinPayment(String btcAddress) {
        this.btcAddress = btcAddress;
    }

    /**
     * Executes a Bitcoin payment.
     * @param amount Amount to be paid.
     */
    @Override
    public void pay(double amount) {
        // Output payment details
        System.out.println("Amount " + amount + " debited via Bitcoin wallet: " + btcAddress);
    }
}
