package family_budget_control;

import family_budget_control.model.Source;

import java.io.*;
import java.util.Scanner;

public class FamilyBudgetAppl implements Serializable{
    public static void main(String[] args) {

        Source source; // Экземпляр класса, управляющего расходами
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to Expense Manager!");

        while (true) {
            printMenu();
            System.out.println("Input your choice: ");
            int choice = getValidatedChoice(scanner);

            switch (choice) {
                case 1 -> addExpense(source, scanner);
                case 2 -> removeExpense(source, scanner);
                case 3 -> editExpense(source, scanner);
                case 4 -> searchExpensesByDate(source, scanner);
                case 5 -> viewExpenseReport(source);
                case 6 -> saveExpensesToFile(source);
                case 7 -> loadExpensesFromFile(source);
                case 8 -> {
                    System.out.println("Exiting... Goodbye!");
                    return;
                }
                default -> System.out.println("Wrong input. Please enter a number from the menu.");
            }
        }
    }

    // Метод для проверки корректности ввода
    private static int getValidatedChoice(Scanner scanner) {
        while (!scanner.hasNextInt()) {
            System.out.println("Invalid input. Please enter a number from the menu.");
            scanner.next(); // Очистить некорректный ввод
        }
        return scanner.nextInt();
    }


}
