package org.howard.edu.lsp.midterm.question1;

public class SecurityOps {
	/**
	 * Encrypts the provided input string by organizing characters at even indices first, 
	 * followed by characters at odd indices, while disregarding any punctuation and whitespace. 
	 * The encryption process retains the case of each character in the resulting encrypted string.
	 *
	 * @param text The input string to be encrypted.
	 * @return The encrypted string.
	 */
    public static String encrypt(String text) {
        // StringBuilder is used to ensure efficient string modification
        StringBuilder evenIndexed = new StringBuilder();
        StringBuilder oddIndexed = new StringBuilder();

        // Removing all non-alphanumeric characters
        text = text.replaceAll("[\\W_]", ""); // Underscore is also considered non-word

        // Iterating over the characters of the string
        for (int i = 0; i < text.length(); i++) {
            if (i % 2 == 0) {
                // Adding characters at even indices
                evenIndexed.append(text.charAt(i));
            } else {
                // Adding characters at odd indices
                oddIndexed.append(text.charAt(i));
            }
        }

        // Combining even and odd indexed characters to encrypt the string
        return evenIndexed.toString() + oddIndexed.toString();
    }
}