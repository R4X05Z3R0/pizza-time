public class Pizza {
    private String name;
    private int id;
    double price;
    String ingredients;

    public Pizza(String name, int id, double price, String ingredients){
        this.name = name;
        this.id = id;
        this.price = price;
        this.ingredients = ingredients;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price){
        this.price = price;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return String.format("%d. %s - %s - %.1fkr.", id, name.toUpperCase() , ingredients, price);
    }
}
