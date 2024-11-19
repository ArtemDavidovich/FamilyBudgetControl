package family_budget_control.view;

import family_budget_control.dao.FamilyBudget;
import family_budget_control.model.Outcome;
import family_budget_control.model.Source;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class FamilyBudgetMenu {

    public static final String FILE_NAME = "outcomes_list.dat";

    private final Scanner scanner = new Scanner(System.in);
    private final FamilyBudget familyBudget;

    public FamilyBudgetMenu(FamilyBudget familyBudget) {
        this.familyBudget = familyBudget;
    }

   private enum MenuOption {
        ADD_EXPENSE("Добавить расход"),
        REMOVE_EXPENSE("Удалить расход"),
        EDIT_EXPENSE("Редактировать расход"),
        SEARCH_EXPENSES("Поиск расходов по датам"),
        VIEW_REPORT("Просмотреть отчет"),
        SAVE_TO_FILE("Сохранить в файл"),
        LOAD_FROM_FILE("Загрузить из файла"),
        EXIT("Выход");

        private final String description;

        MenuOption(String description) {
            this.description = description;
        }

        public String getDescription() {
            return description;
        }

        /*
          все пункты меню.
         */
        public static void displayOptions() {
            for (MenuOption option : MenuOption.values()) {
                System.out.println((option.ordinal() + 1) + ". " + option.getDescription());
            }
        }

        public static MenuOption fromIndex(int index) {
            if (index >= 1 && index <= values().length) {
                return values()[index - 1];
            }
            throw new IllegalArgumentException("Некорректный выбор: " + index);
        }
    }

    /*
     * главного меню.
     */
    public void displayMenu() {
        while (true) {
            System.out.println("\n===== Семейный бюджет - Главное меню =====");
            MenuOption.displayOptions();
            System.out.print("Выберите пункт меню: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            try {
                MenuOption selectedOption = MenuOption.fromIndex(choice);
                handleMenuOption(selectedOption);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void handleMenuOption(MenuOption option) {
        switch (option) {
            case ADD_EXPENSE -> addExpense();
            case REMOVE_EXPENSE -> removeExpense();
            case EDIT_EXPENSE -> editExpense();
            case SEARCH_EXPENSES -> searchExpensesByDate();
            case VIEW_REPORT -> viewReport();
            case SAVE_TO_FILE -> saveExpensesToFile();
            case LOAD_FROM_FILE -> loadExpensesFromFile();
            case EXIT -> {
                System.out.println("Выход из программы. До свидания!");
                System.exit(0);
            }
        }
    }

    // m
    private void addExpense() {
        System.out.println("Введите расходы:");
        //System.out.print("ID: ");
        //int id = scanner.nextInt();
        int id = familyBudget.getIdForAppl();
        System.out.print("Тип расходов: ");
        String type = scanner.nextLine();
        System.out.print("Источник расходов: ");
        String contrAgent = scanner.nextLine();
        System.out.print("Сумма расходов: ");
        double sum = scanner.nextDouble();
        Source source = new Source(type, contrAgent, sum);
        System.out.print("Дата расходов (yyyy-MM-dd): ");
        LocalDate date = LocalDate.parse(scanner.nextLine());
        Outcome outcome = new Outcome(id, source, date);
        if (familyBudget.addOutcome(outcome)) {
            System.out.println("Расход добавлен.");
        } else {
            System.out.println("Ошибка расход не добавлен.");
        }
    }

    private void removeExpense() {
        System.out.print("Введите ID расхода для удаления: ");
        int id = scanner.nextInt();
        if (familyBudget.removeOutcome(id) != null) {
            System.out.println("Расход успешно удален.");
        } else {
            System.out.println("Расход с таким ID не найден.");
        }
    }

    private void editExpense() {
        System.out.print("Введите ID расхода для редактирования: ");
        int id = scanner.nextInt();
        System.out.println("Введите новые значения расходов:");
        System.out.print("Тип расходов: ");
        String type = scanner.nextLine();
        System.out.print("Источник расходов: ");
        String contrAgent = scanner.nextLine();
        System.out.print("Сумма расходов: ");
        double sum = scanner.nextDouble();
        Source source = new Source(type, contrAgent, sum);
        System.out.print("Дата расходов (yyyy-MM-dd): ");
        LocalDate date = LocalDate.parse(scanner.nextLine());
        Outcome newOutcome = new Outcome(id, source, date);
        familyBudget.updateOutcome(id, newOutcome);
        System.out.println("Расход обновлен.");
    }

    private void searchExpensesByDate() {
        System.out.print("Введите начальную дату (YYYY-MM-DD): ");
        LocalDate fromDate = LocalDate.parse(scanner.nextLine());
        System.out.print("Введите конечную дату (YYYY-MM-DD): ");
        LocalDate toDate = LocalDate.parse(scanner.nextLine());

        // Явный тип переменной вместо var
        List<Outcome> outcomes = familyBudget.searchOutcomeByDate(fromDate, toDate);
        if (outcomes.isEmpty()) {
            System.out.println("Расходы за указанный период не найдены.");
        } else {
            System.out.println("Все расходы:");
            outcomes.forEach(System.out::println);
        }
    }

    private void viewReport() {
        System.out.println("Отчет по расходам:");
        familyBudget.outcomeByProduct();
        familyBudget.outcomeByTransport();
        familyBudget.outcomeByMobNetworkAndInternet();
        familyBudget.outcomeByOthers();
    }

    public void saveExpensesToFile() {
        System.out.print("Введите имя файла для сохранения: ");
        String fileName = scanner.nextLine();
        familyBudget.saveTasks(fileName);
        System.out.println("Расходы успешно сохранены.");
    }

    public void loadExpensesFromFile() {
        System.out.print("Введите имя файла для загрузки: ");
        String fileName = scanner.nextLine();
        familyBudget.loadTasks(fileName);
        System.out.println("Расходы успешно загружены.");
    }
}