package family_budget_control.model;

import java.util.Objects;

public class Source implements Comparable<Source>{
    private String type;
    private String contrAgent;
    private double sum;

    public Source(String type, String contrAgent, double sum) {
        this.type = type;
        this.contrAgent = contrAgent;
        this.sum = sum;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getContrAgent() {
        return contrAgent;
    }

    public void setContrAgent(String contrAgent) {
        this.contrAgent = contrAgent;
    }

    public double getSum() {
        return sum;
    }

    public void setSum(double sum) {
        this.sum = sum;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Source source)) return false;
        return Double.compare(sum, source.sum) == 0 && Objects.equals(type, source.type) && Objects.equals(contrAgent, source.contrAgent);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, contrAgent, sum);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Source{");
        sb.append("type='").append(type).append('\'');
        sb.append(", contrAgent='").append(contrAgent).append('\'');
        sb.append(", sum=").append(sum);
        sb.append('}');
        return sb.toString();
    }


    @Override
    public int compareTo(Source o) {
        return this.getType().compareTo(o.getType());
    }
}// end of class
