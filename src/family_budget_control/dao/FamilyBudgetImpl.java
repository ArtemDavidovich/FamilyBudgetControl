package family_budget_control.dao;

import family_budget_control.model.Outcome;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class FamilyBudgetImpl implements FamilyBudget{

    private List<Outcome> outcomes;
    private int quantity;
    private LocalDate time;

    public FamilyBudgetImpl() {
        this.outcomes = new ArrayList<>();
        this.quantity = 0;
    }

    @Override
    public boolean addOutcome(Outcome outcome) {
        if(outcome == null || outcomes.contains(outcome)){
            return false;
        }
        outcomes.add(outcome);
        quantity = outcomes.size();
        return true;
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
    public void updateOutcome(int id, Outcome newOtcome) {

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

    @Override
    public int quantity() {
        return outcomes.size();
    }

}
