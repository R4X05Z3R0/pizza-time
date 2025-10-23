import java.util.ArrayList;

public class PizzaBar {
    ArrayList<Order> orders;
    ArrayList<Customer> customers;
    Menu menu;

    public PizzaBar(ArrayList<Customer> customers, Menu menu) {
        this.customers = customers;
        this.menu = menu;
    }

    public ArrayList<Order> getCompletedOrders() {
        //For loop for orders if completed
        return orders;
    }
}
