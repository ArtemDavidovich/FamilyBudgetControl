package family_budget_control.dao;

import family_budget_control.model.Outcome;

import java.time.LocalDate;
import java.util.List;
import java.util.function.Predicate;

public interface FamilyBudget {
  
    boolean addOutcome(Outcome outcome);

    Outcome removeOutcome(int id);

    List<Outcome> searchOutcomeByDate(LocalDate fromDate, LocalDate toDate);

    Outcome findOutcome(int id);

    boolean updateOutcome(int id, Outcome newOutcome);

    void saveTasks(String fileName);

    void loadTasks(String fileName);

    List<Outcome> findOutcomeByPredicate(Predicate<Outcome> predicate);

    List<Outcome> outcomeByProduct();

    List<Outcome> outcomeByTransport();

    List<Outcome> outcomeByMobNetworkAndInternet();

    List<Outcome> outcomeByOthers();

    int quantity();

    int getIdForAppl();


}
