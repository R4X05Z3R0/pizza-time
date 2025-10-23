import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OrderLineTest {

    @Test
    void getLineTotal() {
        Pizza p = new Pizza("Cheese",1, 5.0,"Cheese and Soap");
        OrderLine order = new OrderLine(p,2);
        double expected = 10.0;
        assertEquals(expected, order.getLineTotal());
    }

    @Test
    void testToString() {
        Pizza p = new Pizza("Cheese",1, 5.0,"Cheese and Soap");
        OrderLine order = new OrderLine(p,2);
        String expected = "2 x Cheese : 10.00kr";
        assertEquals(expected, order.toString());
    }
}