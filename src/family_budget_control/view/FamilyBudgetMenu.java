
package family_budget_control.view;

import java.util.Scanner;

/*
  Предупреждение!!!!
  Я создал заглушки  для методов, которые можно заменить фактической логикой.
 */
public class FamilyBudgetMenu {

    private Scanner scanner = new Scanner(System.in);

    public void displayMenu() {
        while (true) {
            System.out.println("\n===== Семейный бюджет - Главное меню =====");
            System.out.println("1. Добавить расход");
            System.out.println("2. Удалить расход");
            System.out.println("3. Редактировать расход");
            System.out.println("4. Поиск расходов по датам");
            System.out.println("5. Просмотреть отчет по статьям затрат");
            System.out.println("6. Сохранить список расходов в файл");
            System.out.println("7. Загрузить список расходов из файла");
            System.out.println("8. Выход");
            System.out.print("Выберите пункт меню: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Очистка буфера

            switch (choice) {
                case 1 -> addExpense();
                case 2 -> removeExpense();
                case 3 -> editExpense();
                case 4 -> searchExpensesByDate();
                case 5 -> viewReport();
                case 6 -> saveExpensesToFile();
                case 7 -> loadExpensesFromFile();
                case 8 -> {
                    System.out.println("Выход из программы. До свидания!");
                    return;
                }
                default -> System.out.println("Некорректный выбор. Пожалуйста, попробуйте снова.");
            }
        }
    }

    //  Методы + заглушки так как они пока не реализованы.

    private void addExpense() {
        System.out.println("Добавление расхода (заглушка). Реализация требуется.");
    }

    private void removeExpense() {
        System.out.println("Удаление расхода (заглушка). Реализация требуется.");
    }

    private void editExpense() {
        System.out.println("Редактирование расхода (заглушка). Реализация требуется.");
    }

    private void searchExpensesByDate() {
        System.out.println("Поиск расходов по датам (заглушка). Реализация требуется.");
    }

    private void viewReport() {
        System.out.println("Просмотр отчета по затратам (заглушка). Реализация требуется.");
    }

    private void saveExpensesToFile() {
        System.out.println("Сохранение расходов в файл (заглушка). Реализация требуется.");
    }

    private void loadExpensesFromFile() {
        System.out.println("Загрузка расходов из файла (заглушка). Реализация требуется.");
    }

}
