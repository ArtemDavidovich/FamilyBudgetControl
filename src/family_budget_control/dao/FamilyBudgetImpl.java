package family_budget_control.dao;

import family_budget_control.model.Outcome;
import family_budget_control.view.FamilyBudgetMenu;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class FamilyBudgetImpl implements FamilyBudget, Serializable{

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

        for (Outcome outcome : outcomes) { // допустим, outcomes - это список
            if (outcome.getId() == id) {
                outcomes.remove(outcome);
                return outcome; // Возвращаем удалённый объект
            }
        }
        return null;
    }

    @Override
    public List<Outcome> searchOutcomeByDate(LocalDate fromDate, LocalDate toDate) {
        return findOutcomeByPredicate(outcome -> outcome.getDate().isAfter(fromDate.minusDays(1)) && outcome.getDate().isBefore(toDate.plusDays(1)));
    }


    @Override
    public Outcome findOutcome(int id) {
        for (Outcome outcome : outcomes) {
            if(outcome.getId() == id){
                return outcome;
            }
        }
        return null;
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
        // Поток используется для записи объектов в поток вывода, и в данном случае объект будет записан в файл.
        //ObjectOutputStream используется для записи объектов в файл,
        List<Outcome> outcomeList = new ArrayList<>(outcomes);
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FamilyBudgetMenu.FILE_NAME))) {
            oos.writeObject(outcomeList);//Этот метод записывает объект outcomes в поток ObjectOutputStream.
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void loadTasks(String fileName) {
        //Для чтения объектов из файла используется ObjectInputStream
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FamilyBudgetMenu.FILE_NAME))) {
            List<Outcome> loaded = (List<Outcome>) ois.readObject();//используется для чтения объекта из потока.
            // List<Outcome>, который будет прочитан и приведён к нужному типу.
            quantity = loaded.size();
            System.out.println("List of outcomes:");
            int outcomeNumber = 0;
            for (Outcome t: loaded ) {
                System.out.println((outcomeNumber++ + 1) + ". Тип расходов: " + t.getSource().getType() + ", Источник расходов: " + t.getSource().getContrAgent() + ", Сумма расходов: " + t.getSource().getSum() + ", Дата расходов: " + t.getDate()) ;
            }
            //outcomes.clear();
            outcomes.addAll(loaded);
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
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
        return findOutcomeByPredicate(outcome -> outcome.getSource().getType().equals("products"));
    }

    @Override
    public List<Outcome> outcomeByTransport() {
        return findOutcomeByPredicate(outcome -> outcome.getSource().getType().equals("transport"));
    }

    @Override
    public List<Outcome> outcomeByMobNetworkAndInternet() {
        return findOutcomeByPredicate(outcome -> outcome.getSource().getType().equals("communications"));
    }

    @Override
    public List<Outcome> outcomeByOthers() {
        return findOutcomeByPredicate(outcome -> outcome.getSource().getType().equals("others"));
    }

    @Override
    public int quantity() {
        return outcomes.size();
    }

    @Override
    public int getIdForAppl() {
        return outcomes.stream()
                .map(Outcome::getId)
                .skip(outcomes.size() - 1)
                .findAny()
                .orElse(1);
    }

}//end of class
