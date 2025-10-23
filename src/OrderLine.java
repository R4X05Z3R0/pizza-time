public class OrderLine {
    Pizza pizza;
    int amount;

    public OrderLine(Pizza pizza, int amount){
        this.pizza =  pizza;
        this.amount = amount;
    }

    public int getAmount(){
        return amount;
    }

    public double getLineTotal(){
        return pizza.getPrice() * getAmount();
    }

    @Override
    public String toString() {
        return String.format("%d x %s : %.2fkr", getAmount(), pizza.getName(), getLineTotal());
    }
}

