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
    }

    @Test
    @DisplayName("")
    void testUpdateOutcome() {
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