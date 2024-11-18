package family_budget_control.dao;

import family_budget_control.model.Outcome;
import family_budget_control.model.Source;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import java.util.function.Predicate;

public interface FamilyBudget {
    boolean addOutcome(Outcome outcome);
//karina
    Outcome removeOutcome(int id);

    List<Outcome> searchOutcome(LocalDate fromDate, LocalDate toDate);

    Outcome findOutcome(int id);

    void updateOutcome(int id, Outcome newOutcome);
//karina
    void saveTasks(String fileName) throws IOException;
//karina
    void loadTasks(String fileName) throws IOException;
    List<Outcome> findOutcomeByPredicate(Predicate<Outcome> predicate);
    void outcomeByProduct();
    void outcomeByTransport();
    void outcomeByMobNetworkAndInternet();
    void outcomeByOthers();



}
