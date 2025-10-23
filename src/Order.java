import java.util.ArrayList;

public class Order {
    ArrayList<OrderLine> lines;
    boolean completed; //Remember to use flag to sort completed orders

    public Order(){
        this.lines = new ArrayList<>();
    }

    public void addLine(Pizza pizza, int amount){
        lines.add(new OrderLine(pizza, amount));
    }

    public double getTotal(){
        double sum = 0;
        for (OrderLine line: lines ){
            sum += line.getLineTotal();
        }
        return sum;
    }

    @Override
    public String toString() {
        String receipt = "";
        for (OrderLine line : lines){
            receipt += line.toString() + "\n";
        }
        return receipt +
                "-----------------\n"+
                "Total: " + String.format("%.2fkr", getTotal());
    }
}
