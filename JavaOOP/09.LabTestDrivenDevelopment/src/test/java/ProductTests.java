import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ProductTests {

    private final Product product = new Product("Test_Label", 5.7, 3);

    @Test
    public void testProductGetAndSetLabel() {
        product.setLabel("Set_Label");
        assertEquals("Set_Label", product.getLabel());
    }

    @Test
    public void testProductGetAndSetPrice() {
        product.setPrice(6.6);
        assertEquals(6.6, product.getPrice());
    }

    @Test
    public void testProductGetAndSetQuantity() {
        product.setQuantity(5);
        assertEquals(5, product.getQuantity());
    }

    @Test
    public void testProductComparator() {
        Product product2 = new Product("A_Label", 6.8, 2);
        assertTrue(product.compareTo(product2) > 0);
    }
}
