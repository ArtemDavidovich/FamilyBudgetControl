package family_budget_control.model;

import java.time.LocalDate;
import java.util.Objects;

public class Outcome {

    private final int id;
    private Source source;
    private LocalDate date;

    public Outcome(int id, Source source, LocalDate date) {
        this.id = id;
        this.source = source;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public Source getSource() {
        return source;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Outcome outcome)) return false;
        return id == outcome.id && Objects.equals(source, outcome.source) && Objects.equals(date, outcome.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, source, date);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Outcome{");
        sb.append("id=").append(id);
        sb.append(", source=").append(source);
        sb.append(", date=").append(date);
        sb.append('}');
        return sb.toString();
    }

}// end of class
