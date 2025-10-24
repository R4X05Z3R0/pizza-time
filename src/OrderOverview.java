import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class OrderOverview {
    Customer customer;
    Order order;
    LocalDateTime now;
    DateTimeFormatter formatter;
    String orderTime ;
    int id;

    public OrderOverview(Customer customer, Order order, int id){
        this.customer = customer;
        this.now = LocalDateTime.now();
        this.order = order;
        this.formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy : HH.mm");
        this.orderTime = now.format(formatter);
        this.id = id;
    }

    public void displayOverview(){
        System.out.println("\nOrder Overview:\n" + order
                + "\nTo " + customer.getName() +
                ", Phone Number: " + customer.getPhoneNumber()+
                "\nOrder Time : " + orderTime + "\n");
    }

    public void displayOrder(){
        String list = "";
        for (OrderLine line : order.getLines()){
            list += line.getItems() + "\n";
        }
        System.out.println("Order No: " + getId() + "\n" +
                list +
                "To " + customer.getName() +
                "\nOrder Time : " + orderTime + "\n");
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return  "Order No: " + getId() + "\n" +
                 order +
                "\nTo " + customer.getName() + ", Phone Number: " + customer.getPhoneNumber()+
                "\nOrder Time : " + orderTime;
    }
}
