import java.time.LocalDateTime;
import java.util.ArrayList;

public class PizzaBar {
    ArrayList<OrderOverview> orders;
    ArrayList<Customer> customers;
    Menu menu;


    public PizzaBar(Menu menu) {
        this.orders = new ArrayList<>();
        this.customers = new ArrayList<>();
        this.menu = menu;
    }




    public ArrayList<OrderOverview> getCompletedOrders() {
        //For loop for orders if completed
        ArrayList<OrderOverview> completedOrders1 = new ArrayList<>();

        for (OrderOverview order : orders){
            if (order.isCompleted()){
                completedOrders1.add(order);
            }
        }
        return completedOrders1;
    }

    public void displayCompletedOrders(){
        boolean found = false;
        for (OrderOverview ready : getCompletedOrders()){
            if(!getCompletedOrders().isEmpty()) {
                System.out.println(ready);
                found = true;
            }
            System.out.println("\n");
        }
        if (!found){
            System.out.println("No History\n");
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

    public boolean setReady(int orderID) {
        OrderOverview a = findOrderbyID(orderID);
        if (a != null){
            a.setCompleted();
            System.out.println("\nORDER (" + a.getId() + ") READY");
            return false;
        }
        return true;
    }

    public void displayOrder() {
        System.out.println("------ALL ORDERS-----");
        boolean found = false;

        for (OrderOverview order : orders) {
            if (!order.isCompleted()) {
                order.displayOrder();
                found = true;
            }
        }

        if (!found) {
            System.out.println("No Current Orders\n");
        }
    }

    public ArrayList<Customer> getCustomers(){
        return customers;
    }

    public void displayCustomers(){
        boolean found = false;

        for(Customer people : getCustomers()) {
            if (!customers.isEmpty()) {
                System.out.printf("Name: %s, Phone Number: %s%n", people.getName(), people.getPhoneNumber());
                found = true;
            }
        }

        if (!found){
            System.out.println("NO REGISTERED CUSTOMERS\n");
        }
    }

    public void addCustomer(String name, String number) {
        customers.add(new Customer(name,number));
        System.out.println("Customer Added!\n");
    }
}
