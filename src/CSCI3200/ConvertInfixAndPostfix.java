//-----------------------------------------------------------------------------
// Group Members: Pramit Patel, Rohan Karve
// Date: Oct 30, 2026
// Course: Data Structures and Algorithm Analysis (CSCI 3200)
// Project Description: Project 3 - Uses a reference-based linked list stack to
// convert infix expressions to postfix and postfix expressions to infix. A menu
// lets the user keep converting expressions until they enter 0.
//-----------------------------------------------------------------------------
package CSCI3200;

import java.util.Scanner;

// main executable class with console menu loop
public class ConvertInfixAndPostfix {

    // main method to run the program loop
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        InfixAndPostfix converter = new InfixAndPostfix();
        int choice;

        do {
            System.out.println("//////////////////////////////////////");
            System.out.println("/ 0: Exit                            /");
            System.out.println("/ 1: Infix to Postfix                /");
            System.out.println("/ 2: Postfix to Infix                /");
            System.out.println("//////////////////////////////////////");
            System.out.print("Enter a choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter an infix expression: ");
                    String infix = scanner.nextLine();
                    String postfixResult = converter.convertToPostfix(infix);
                    System.out.println("The postfix expression of " + infix + " = " + postfixResult);
                    break;
                case 2:
                    System.out.print("Enter a postfix expression: ");
                    String postfix = scanner.nextLine();
                    String infixResult = converter.convertToInfix(postfix);
                    System.out.println("The infix expression of " + postfix + " = " + infixResult);
                    break;
                case 0:
                    System.out.println("Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 0);

        scanner.close();
    }
}