package userInputs;

import java.util.Scanner;

public class ScannerUserInput {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        int n = scanner.nextInt();

        System.out.println(input + ": " + n);
    }
}
