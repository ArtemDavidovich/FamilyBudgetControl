package family_budget_control.test;

import family_budget_control.dao.FamilyBudget;
import family_budget_control.dao.FamilyBudgetImpl;
import family_budget_control.model.Outcome;
import family_budget_control.model.Source;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;
class FamilyBudgetImplTest {

    FamilyBudget familyBudget;
    LocalDate now = LocalDate.now();

    Source source1 = new Source("products", "rewe", 27.50);
    Source source2 = new Source("transport", "aral", 50);
    Source source3 = new Source("products", "aldi", 18.65);
    Source source4 = new Source("communications", "vodafone", 30);
    Source source5 = new Source("others", "cinema", 10.50);
    Source source6 = new Source("transport", "bus", 3.50);

    @BeforeEach
    void setUp() {

        familyBudget = new FamilyBudgetImpl();

        familyBudget.addOutcome(new Outcome(1, source1, now.minusDays(13)));
        familyBudget.addOutcome(new Outcome(2, source2, now.minusDays(11)));
        familyBudget.addOutcome(new Outcome(3, source3, now.minusDays(10)));
        familyBudget.addOutcome(new Outcome(4, source4, now.minusDays(7)));
        familyBudget.addOutcome(new Outcome(5, source5, now.minusDays(7)));
        familyBudget.addOutcome(new Outcome(6, source6, now.minusDays(4)));

    }

    @Test
    @DisplayName("Adding new outcomes")
    void testAddOutcome() {
        assertFalse(familyBudget.addOutcome(null));
        assertFalse(familyBudget.addOutcome(new Outcome(1, source1, now.minusDays(13))));
        Source source7 = new Source("products", "lidl", 15.25);
        assertTrue(familyBudget.addOutcome(new Outcome(7, source7, now.minusDays(5))));
        assertEquals(7, familyBudget.quantity());
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

    // TO DO test for quantity()
}