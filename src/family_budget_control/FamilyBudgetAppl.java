package family_budget_control;

import family_budget_control.dao.FamilyBudgetImpl;
import family_budget_control.view.FamilyBudgetMenu;

import java.io.Serializable;

public class FamilyBudgetAppl implements Serializable {

    public static void main(String[] args) {

        // Create a FamilyBudgetImpl instance (data access layer)
        FamilyBudgetImpl familyBudget = new FamilyBudgetImpl();

        // Pass it to the menu layer for user interaction
        FamilyBudgetMenu menu = new FamilyBudgetMenu(familyBudget);

        menu.displayMenu();

    }
}

