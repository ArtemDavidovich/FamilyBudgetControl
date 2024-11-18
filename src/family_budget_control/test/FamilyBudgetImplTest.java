package family_budget_control.test;

import family_budget_control.dao.FamilyBudget;
import family_budget_control.dao.FamilyBudgetImpl;
import family_budget_control.model.Outcome;
import family_budget_control.model.Source;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;

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
        // Проверяем существующую запись
        Outcome foundOutcome = familyBudget.findOutcome(1); // Найти запись с ID 1
        assertNotNull(foundOutcome); // Убедиться, что запись найдена
        assertEquals("products", foundOutcome.getSource().getType()); // Проверить категорию
        assertEquals("rewe", foundOutcome.getSource().getContrAgent()); // Проверить название
        assertEquals(27.50, foundOutcome.getSource().getSum()); // Проверить сумму

        // Проверяем отсутствие записи
        assertNull(familyBudget.findOutcome(7)); // Убедиться, что запись с ID 7 отсутствует
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
        List<Outcome> products = familyBudget.outcomeByProduct("products");
        assertNotNull(products); // Убедиться, что результат не null
        assertEquals(2, products.size()); // Проверить количество расходов

        // Проверить, что все результаты принадлежат категории "products"
        for (Outcome outcome : products) {
            assertEquals("products", outcome.getSource().getType());
        }
    }

    @Test
    @DisplayName("")
    void testOutcomeByTransport() {
        List<Outcome> transport = familyBudget.outcomeByTransport("transport");
        assertNotNull(transport);
        assertEquals(2, transport.size());

        for (Outcome outcome : transport) {
            assertEquals("transport", outcome.getSource().getType());
        }
    }

    @Test
    @DisplayName("")
    void testOutcomeByMobNetworkAndInternet() {
        List<Outcome> communications = familyBudget.outcomeByMobNetworkAndInternet("communications");
        assertNotNull(communications);
        assertEquals(1, communications.size());

        for (Outcome outcome : communications) {
            assertEquals("communications", outcome.getSource().getType());
        }
    }

    @Test
    @DisplayName("")
    void testOutcomeByOthers() {
        List<Outcome> others = familyBudget.outcomeByOthers("others");
        assertNotNull(others);
        assertTrue(others.isEmpty()); // Проверить, что список пуст, если расходов в категории нет
    }
}