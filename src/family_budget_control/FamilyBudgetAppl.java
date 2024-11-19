package family_budget_control;

import family_budget_control.view.FamilyBudgetMenu;

import java.io.Serializable;

public class FamilyBudgetAppl implements Serializable {
  
    public static void main(String[] args) {

        FamilyBudgetMenu familyBudgetMenu = new FamilyBudgetMenu();
        familyBudgetMenu.displayMenu();


        }
    }

