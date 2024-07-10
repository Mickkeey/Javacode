package base;

public class PalindromeChecker {
    private String inputString;

    // Constructor to initialize the input string
    public PalindromeChecker(String inputString) {
        this.inputString = inputString;
    }

    // Method to check if the string is a palindrome
    public String isPalindrome() {
        int length = inputString.length();
        for (int i = 0; i < length / 2; i++) {
            if (inputString.charAt(i) != inputString.charAt(length - i - 1)) {
                return "Non Palindrome";
            }
        }
        return "Palindrome";
    }

    // Main method for testing
    public static void main(String[] args) {
        String input = "racecar";
        PalindromeChecker checker = new PalindromeChecker(input);
        String result = checker.isPalindrome();
        System.out.println("The string '" + input + "' is " + result + ".");
    }
}