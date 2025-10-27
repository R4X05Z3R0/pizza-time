import java.time.LocalDateTime;
import java.util.ArrayList;

public class PizzaBar {
    ArrayList<OrderOverview> orders;
    ArrayList<OrderOverview> completedOrders;
    ArrayList<Customer> customers;
    Menu menu;


    public PizzaBar(Menu menu) {
        this.orders = new ArrayList<>();
        this.completedOrders = new ArrayList<>();
        this.menu = menu;
    }




    public ArrayList<OrderOverview> getCompletedOrders() {
        //For loop for orders if completed
        for (OrderOverview order : orders){
            if (order.isCompleted()){
                completedOrders.add(order);
            }
        }
        return completedOrders;
    }

    public void displayCompletedOrders(){
        for (OrderOverview ready : getCompletedOrders()){
            System.out.println(ready);
        }
    }

    public void addOrder(OrderOverview order){
        orders.add(order);
    }

    public OrderOverview findOrderbyID(int orderID){
        for (OrderOverview order : orders) {
            if (order.getId() == orderID) {
                return order;
            }
        }
        System.out.println("Order not found");
        return null;
    }

    public void setReady(int orderID) {
        OrderOverview a = findOrderbyID(orderID);
        a.setCompleted();
        System.out.println("\nORDER (" + a.getId() + "): READY");
    }

    public boolean displayOrder() {
        System.out.println("------ALL ORDERS-----");
        boolean found = false;

        for (OrderOverview order : orders) {
            if (!order.isCompleted()) {
                order.displayOrder();
                found = true;
            }
        }

        if (!found) {
            System.out.println("No Current Orders");
        }

        return found;
    }

    public ArrayList<Customer> getCustomers(){
        return customers;
    }

}
