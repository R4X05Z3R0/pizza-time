import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
public class PizzaTest {

    @Test
    void testToString(){
        Pizza p  = new Pizza("Maga",1, 5.9,"Cheese and Soap");
        String expected = "1. Maga - Cheese and Soap - 5.9kr.";
        assertEquals(expected, p.toString());
    }
}
