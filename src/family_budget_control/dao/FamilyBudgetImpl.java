package family_budget_control.dao;

import family_budget_control.model.Outcome;
import family_budget_control.model.Source;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class FamilyBudgetImpl implements FamilyBudget {
    private List<Outcome> outcomes = new ArrayList<>();

    @Override
    public boolean addOutcome(Outcome outcome) {

        return false;
    }

    @Override
    public Outcome removeOutcome(int id) {
        Outcome toRemove = outcomes.stream()
                .filter(outcome -> outcome.getId() == id) //фильтрую элементы по соответствующему id
                .findFirst()
                .orElse(null);
        if (toRemove != null) {
            outcomes.remove(toRemove);//удалила найденный объект
        }

        return toRemove;//возвращаем удаленный объект или null
    }

    @Override
    public List<Outcome> searchOutcome(LocalDate fromDate, LocalDate toDate) {
        return List.of();
    }

    @Override
    public Outcome findOutcome(int id) {
        return null;
    }

    @Override
    public void updateOutcome(int id, Outcome newOutcome) {

    }

    @Override
    public void saveTasks(String fileName) throws IOException {
        // Поток используется для записи объектов в поток вывода, и в данном случае объект будет записан в файл.
        //ObjectOutputStream используется для записи объектов в файл,
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
            oos.writeObject(outcomes);//Этот метод записывает объект outcomes в поток ObjectOutputStream.
        }


    }

    @Override
    public void loadTasks(String fileName) throws IOException {
        //Для чтения объектов из файла используется ObjectInputStream
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
            List<Outcome> loaded = (List<Outcome>) ois.readObject();//используется для чтения объекта из потока.
            // List<Outcome>, который будет прочитан и приведён к нужному типу.
            outcomes.clear();
            outcomes.addAll(loaded);

        } catch (ClassNotFoundException e) {
            throw new IOException("Формат файла не поддерживается", e);
        }


    }

    @Override
    public List<Outcome> findOutcomeByPredicate(Predicate<Outcome> predicate) {
        //  return outcomes.stream().filter(predicate).toList();
        return List.of();
    }

    @Override
    public void outcomeByProduct() {

    }

    @Override
    public void outcomeByTransport() {

    }

    @Override
    public void outcomeByMobNetworkAndInternet() {

    }

    @Override
    public void outcomeByOthers() {

    }

}
