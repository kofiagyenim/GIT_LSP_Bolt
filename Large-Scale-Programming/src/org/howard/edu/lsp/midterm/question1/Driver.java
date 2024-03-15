package org.howard.edu.lsp.midterm.question1;

/**
 * Driver class to test the encrypt method of the SecurityOps class.
 */
public class Driver {

    /**
     * Main method to test the encrypt method by passing in the string "I love CSCI363".
     * It prints both the original and encrypted texts to stdout (the screen).
     *
     * @param args Command-line arguments (not used).
     */
    public static void main(String[] args) {
        // Test 1 of the encrypt method
        String text = "I love CSCI363";
        String encryptedText = SecurityOps.encrypt(text);
        System.out.println("Original text: " + text);
        System.out.println("Encrypted text: " + encryptedText);
        
        //Test 2 of the encrypt method
        String text1 = "I love pRograMMing";
        String encryptedText1 = SecurityOps.encrypt(text1);
        System.out.println("Original text: " + text1);
        System.out.println("Encrypted text: " + encryptedText1);
    }
}

