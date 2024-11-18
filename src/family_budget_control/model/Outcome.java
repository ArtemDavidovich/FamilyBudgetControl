package family_budget_control.model;

import java.util.Objects;

public class Outcome {
    private double products;
    private double transport;
    private double communication;
    private double other;

    public Outcome(double products, double transport, double communication, double other) {
        this.products = products;
        this.transport = transport;
        this.communication = communication;
        this.other = other;
    }

    public double getProducts() {
        return products;
    }

    public void setProducts(double products) {
        this.products = products;
    }

    public double getTransport() {
        return transport;
    }

    public void setTransport(double transport) {
        this.transport = transport;
    }

    public double getCommunication() {
        return communication;
    }

    public void setCommunication(double communication) {
        this.communication = communication;
    }

    public double getOther() {
        return other;
    }

    public void setOther(double other) {
        this.other = other;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Outcome{");
        sb.append("products=").append(products);
        sb.append(", transport=").append(transport);
        sb.append(", communication=").append(communication);
        sb.append(", other=").append(other);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Outcome outcome)) return false;
        return Double.compare(products, outcome.products) == 0 && Double.compare(transport, outcome.transport) == 0 && Double.compare(communication, outcome.communication) == 0 && Double.compare(other, outcome.other) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(products, transport, communication, other);
    }
}// end of class
