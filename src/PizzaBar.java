import java.time.LocalDateTime;
import java.util.ArrayList;

public class PizzaBar {
    ArrayList<OrderOverview> orders;
    ArrayList<Customer> customers;
    Menu menu;


    public PizzaBar(Menu menu) {
        this.orders = new ArrayList<>();
        this.menu = menu;
    }


    public ArrayList<OrderOverview> getCompletedOrders() {
        //For loop for orders if completed
        return orders;
    }

    public void addOrder(OrderOverview order){
        orders.add(order);
    }


    public void displayOrder(){
        for (OrderOverview order : orders){
            order.displayOrder();
        }
    }

    public ArrayList<Customer> getCustomers(){
        return customers;
    }

}
