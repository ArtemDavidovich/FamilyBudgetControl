package family_budget_control;

import family_budget_control.dao.FamilyBudget;
import family_budget_control.dao.FamilyBudgetImpl;
import family_budget_control.model.Source;
import family_budget_control.view.FamilyBudgetMenu;

import java.io.*;
import java.util.Scanner;

public class FamilyBudgetAppl implements Serializable{
    public static void main(String[] args) {

        FamilyBudgetMenu familyBudgetMenu = new FamilyBudgetMenu();
        familyBudgetMenu.displayMenu();




    }
}
