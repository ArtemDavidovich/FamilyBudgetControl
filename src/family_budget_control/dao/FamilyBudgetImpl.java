package family_budget_control.dao;

import family_budget_control.model.Outcome;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class  FamilyBudgetImpl implements FamilyBudget{

    private final List<Outcome> outcomes = new ArrayList<>();

    @Override
    public boolean addOutcome(Outcome outcome) {
        return false;
    }

    @Override
    public Outcome removeOutcome(int id) {
        return null;
    }

    @Override
    public List<Outcome> searchOutcome(LocalDate fromDate, LocalDate toDate) {
        return List.of();
    }

    @Override
    public Outcome findOutcome(int id) {
        return null;
    }



    @Override
    public boolean updateOutcome(int id, Outcome newOutcome) {
        if (newOutcome == null) {
           return false;
        }
        for (int i = 0; i < outcomes.size(); i++) {
            Outcome currentOutcome = outcomes.get(i);
            if (currentOutcome.getId() == id) {
                outcomes.set(i, newOutcome);
                break;
            }
        }
        return true;
    }

    @Override
    public void saveTasks(String fileName) {

    }

    @Override
    public void loadTasks(String fileName) {

    }

    @Override
    public List<Outcome> findOutcomeByPredicate(Predicate<Outcome> predicate) {
        return List.of();
    }

    @Override
    public void outcomeByProduct() {

    }

    @Override
    public void outcomeByTransport() {

    }

    @Override
    public void outcomeByMobNetworkAndInternet() {

    }

    @Override
    public void outcomeByOthers() {

    }

}
