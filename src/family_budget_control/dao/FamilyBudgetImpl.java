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
        // Создаём предикат для поиска
        Predicate<Outcome> findByIdPredicate = outcome -> outcome.getId() == id;

        // Ищем объект с помощью предиката
        return outcomes.stream()
                .filter(findByIdPredicate)
                .findFirst()
                .orElse(null); // Возвращаем null, если объект не найден
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
        List<Outcome> outcomesPredicate = new ArrayList<>();
        for (int i = 0; i < outcomes.size(); i++) {
            if(predicate.test(outcomes.get(i))){
                outcomesPredicate.add(outcomes.get(i));
            }
        }
        return outcomesPredicate;
    }

    @Override
    public List<Outcome> outcomeByProduct() {
        return null;
    }

    @Override
    public List<Outcome> outcomeByTransport() {
        return null;
    }

    @Override
    public List<Outcome> outcomeByMobNetworkAndInternet() {
        return null;
    }

    @Override
    public List<Outcome> outcomeByOthers() {
        return null;
    }

    @Override
    public int quantity() {
        return outcomes.size();
    }

}
