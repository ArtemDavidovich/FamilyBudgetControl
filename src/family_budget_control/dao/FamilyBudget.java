package family_budget_control.dao;

import family_budget_control.model.Outcome;
import family_budget_control.model.Source;

import java.time.LocalDate;
import java.util.List;
import java.util.function.Predicate;

public interface FamilyBudget {
    boolean addOutcome(Outcome outcome);

    Outcome removeOutcome(int id);

    List<Outcome> searchOutcome(LocalDate fromDate, LocalDate toDate);

    Outcome findOutcome(int id);

    void updateOutcome(int id, Outcome newOutcome);

    void saveTasks(String fileName);

    void loadTasks(String fileName);
    List<Outcome> findOutcomeByPredicate(Predicate<Outcome> predicate);
    void outcomeByProduct();
    void outcomeByTransport();
    void outcomeByMobNetworkAndInternet();
    void outcomeByOthers();


}
