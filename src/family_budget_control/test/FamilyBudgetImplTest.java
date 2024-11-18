package family_budget_control.test;

import family_budget_control.dao.FamilyBudget;
import family_budget_control.dao.FamilyBudgetImpl;
import family_budget_control.model.Outcome;
import family_budget_control.model.Source;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FamilyBudgetImplTest {
    FamilyBudget familyBudget;
    LocalDate now = LocalDate.now();
    Source source;
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
        Source source1 = new Source("products","rewe",27.50);
        Outcome outcome = new Outcome(1, source1, LocalDate.now());

        familyBudget.addOutcome(outcome);
        Outcome removeOutcome = familyBudget.removeOutcome(1);
        assertNotNull(removeOutcome,"Удаленный результат не должен быть нулевым");
        assertNull(familyBudget.findOutcome(1));
        assertEquals(1,removeOutcome.getId(),"Удалённый результат должен иметь правильный ID.");
        assertEquals(0,familyBudget.quantity(),"FamilyBudget должен быть пустым после удаления.");
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
        assertFalse(familyBudget.updateOutcome(1,null));
        Source source = new Source("products", "lidl", 27.50);
        assertTrue(familyBudget.updateOutcome(1, new Outcome(1, source, now.minusDays(13))));
    }

    @Test
    @DisplayName("")
    void testSaveTasks() throws IOException {
       LocalDate now = LocalDate.now();
       Source source1 = new Source("products","rewe",27.50);
       familyBudget.addOutcome(new Outcome(1,source1,now));

       String fileName = "test_tasks.dat";

       familyBudget.saveTasks(fileName);

        File file = new File(fileName);
        assertTrue(file.exists(),"Файл должен быть создан.");
        assertTrue(file.length() > 0, "Файл не должен быть пустым.");

        file.delete();//удаление после теста
    }


    @Test
    @DisplayName("")
    void testLoadTasks() throws IOException{
        LocalDate now = LocalDate.now();
        Source source1 =  new Source("products","rewe",27.50);
        familyBudget.addOutcome(new Outcome(1,source1,now));

        String fileName = "test_tasks.dat";
 //сохраняем данные в файл
        familyBudget.saveTasks(fileName);

        //объект для загрузки данных
        FamilyBudgetImpl newFamilyBudget = new FamilyBudgetImpl();

        newFamilyBudget.loadTasks(fileName);//загружаю данные из файла

        Outcome loadedOutcome = newFamilyBudget.findOutcome(1);

        assertNotNull(loadedOutcome, "Результат должен быть загружен из файла");
        assertEquals(1, loadedOutcome.getId(),"ID загруженного результата должен совпадать с сохраненным");
        assertEquals("products", loadedOutcome.getSource().getSum(),"Сумма загруженного результата должна соответствовать сохраненной.");

        File file = new File(fileName);
        file.delete();//
    }

    @Test
    @DisplayName("")
    void testFindOutcomeByPredicate() {
    }

    @Test
    @DisplayName("")
    void testOutcomeByProduct() {
        List<Outcome> products = familyBudget.outcomeByProduct();
        assertNotNull(products); // Убедиться, что результат не null
        assertEquals(2, products.size());

        // Проверить, что все результаты принадлежат категории "products"
        for (Outcome outcome : products) {
            assertEquals("products", outcome.getSource().getType());
        }
    }

    @Test
    @DisplayName("")
    void testOutcomeByTransport() {
        List<Outcome> transport = familyBudget.outcomeByTransport();
        assertNotNull(transport);
        assertEquals(2, transport.size());

        for (Outcome outcome : transport) {
            assertEquals("transport", outcome.getSource().getType());
        }
    }

    @Test
    @DisplayName("")
    void testOutcomeByMobNetworkAndInternet() {
        List<Outcome> communications = familyBudget.outcomeByMobNetworkAndInternet();
        assertNotNull(communications);
        assertEquals(1, communications.size());

        for (Outcome outcome : communications) {
            assertEquals("communications", outcome.getSource().getType());
        }
    }

    @Test
    @DisplayName("")
    void testOutcomeByOthers() {
        List<Outcome> others = familyBudget.outcomeByOthers();
        assertNotNull(others);
        assertTrue(others.isEmpty()); // Проверить, что список пуст, если расходов в категории нет
    }

    // TO DO test for quantity()

}