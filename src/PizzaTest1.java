import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PizzaTest1 {

    @Test
    void testToString() {
        Pizza p  = new Pizza("Maga",1, 5.0,"Cheese and Soap");
        String expected = "1. Maga - Cheese and Soap - 5.0kr.";
        assertEquals(expected, p.toString());
    }
}