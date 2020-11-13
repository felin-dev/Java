package _3_ShoppingSpree;

public class Product {
    private String name;
    private double cost;

    public Product (String name,  double cost) {
        setName(name);
        setCost(cost);
    }

    private void setName (String name) {
        NameValidator.validate(name);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    private void setCost (double cost) {
        NotNegativeDoubleValidator.validate(cost);
        this.cost = cost;
    }

    public double getCost() {
        return cost;
    }

    @Override
    public String toString() {
        return name;
    }
}
