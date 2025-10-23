import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OrderTest {

    @Test
    void addLine() {
    }

    @Test
    void getTotal() {
        Pizza cheese = new Pizza("Cheese", 1, 5.0,"Cheese and Soap");
        Pizza kebab = new Pizza("Kebab" , 2 , 4.0 , "Kebab and Matcha");
        Order order = new Order();
        order.addLine(cheese,2);
        order.addLine(kebab, 2);
        double expected = 18.00;
        assertEquals(expected, order.getTotal());
    }

    @Test
    void testToString() {
        Pizza cheese = new Pizza("Cheese", 1, 5.0,"Cheese and Soap");
        Pizza kebab = new Pizza("Kebab" , 2 , 4.0 , "Kebab and Matcha");
        Order order = new Order();
        order.addLine(cheese, 2);
        order.addLine(kebab, 2);

        String expected = """
                2 x Cheese : 10.00kr
                2 x Kebab : 8.00kr
                -----------------
                Total: 18.00kr""";

        assertEquals(expected, order.toString());
    }
}