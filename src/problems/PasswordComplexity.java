package problems;

import java.util.Scanner;

public class PasswordComplexity {

    public static boolean isPasswordComplex(String password) {
        return password != null &&
            password.length() >= 6 &&
            password.matches(".*\\d.*") &&
            password.matches(".*[a-z].*") &&
            password.matches(".*[A-Z].*");

        // if (password == null || password.length() < 6) return false;

        // if (!hasUpercaseLetter(password)) return false;

        // if (!hasLowercaseLetter(password)) return false;

        // if (!hasAnumber(password)) return false;

        // return true;
    }

    public static void main(String[] args) {

       Scanner scanner = new Scanner(System.in);

       System.out.println("Enter a password: ");
       String userInput = scanner.nextLine();
       System.out.println("Is the password complex? " +
               isPasswordComplex(userInput));
    }

    static boolean hasUpercaseLetter(String password) {
        return !password.equals(password.toLowerCase());
    }

    static boolean hasLowercaseLetter(String password) {
        return !password.equals(password.toUpperCase());
    }

    static boolean hasAnumber(String password) {

        for(char ch : password.toCharArray())
            if (Character.isDigit(ch)) return true;

        return false;
    }

}
