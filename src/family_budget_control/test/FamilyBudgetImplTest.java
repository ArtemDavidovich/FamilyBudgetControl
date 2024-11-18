package family_budget_control.test;

import family_budget_control.dao.FamilyBudget;
import family_budget_control.dao.FamilyBudgetImpl;
import family_budget_control.model.Outcome;
import family_budget_control.model.Source;
import jdk.jfr.Event;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;
class FamilyBudgetImplTest {
    FamilyBudget familyBudget;
    LocalDate now = LocalDate.now();
    @BeforeEach
    void setUp() {
        Source source1 = new Source("products", "rewe", 27.50);
        Source source2 = new Source("transport", "aral", 27.50);
        Source source3 = new Source("products", "aldi", 27.50);
        Source source4 = new Source("communications", "vodafone", 27.50);
        Source source5 = new Source("entertainment", "cinema", 27.50);
        Source source6 = new Source("transport", "bus", 27.50);
        familyBudget = new FamilyBudgetImpl();
        familyBudget.addOutcome(new Outcome(1, source1, now.minusDays(13)));
        familyBudget.addOutcome(new Outcome(2, source2, now.minusDays(11)));
        familyBudget.addOutcome(new Outcome(3, source3, now.minusDays(10)));
        familyBudget.addOutcome(new Outcome(4, source4, now.minusDays(7)));
        familyBudget.addOutcome(new Outcome(5, source5, now.minusDays(7)));
        familyBudget.addOutcome(new Outcome(6, source6, now.minusDays(4)));
    }

    @Test
    @DisplayName("")
    void testAddOutcome() {
    }

    @Test
    @DisplayName("")
    void testRemoveOutcome() {
    }

    @Test
    @DisplayName("")
    void testSearchOutcome() {
    }

    @Test
    @DisplayName("")
    void testFindOutcome() {
    }

    @Test
    @DisplayName("")
    void testUpdateOutcome() {
        assertFalse(familyBudget.updateOutcome(1,null));
        Source source = new Source("products", "lidl", 27.50);
        assertTrue(familyBudget.updateOutcome(1, new Outcome(1, source, now.minusDays(13))));
    }

    @Test
    @DisplayName("")
    void testSaveTasks() {
    }

    @Test
    @DisplayName("")
    void testLoadTasks() {
    }

    @Test
    @DisplayName("")
    void testFindOutcomeByPredicate() {
    }

    @Test
    @DisplayName("")
    void testOutcomeByProduct() {
    }

    @Test
    @DisplayName("")
    void testOutcomeByTransport() {
    }

    @Test
    @DisplayName("")
    void testOutcomeByMobNetworkAndInternet() {
    }

    @Test
    @DisplayName("")
    void testOutcomeByOthers() {
    }
}