import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ProductStockTest {

    private final ProductStock stock = new Instock();

    @Test
    void testCountShouldReturnCorrectSize() {
        stock.add(createProduct(0));
        stock.add(createProduct(1));
        assertEquals(2, stock.getCount());
    }

    @Test
    void testStockContainsProductWorkingCorrectly() {
        Product product = createProduct(0);
        assertFalse(stock.contains(product));
        stock.add(product);
        assertTrue(stock.contains(product));
    }

    @Test
    void testStockFindsTheCorrectFirstItemByIndex() {
        Product product = createProduct(3);
        stock.add(product);
        fillStock();
        Product actual = stock.find(0);
        assertNotNull(actual);
        assertEquals(product.getLabel(), actual.getLabel());
    }

    @Test
    void testStockFindsTheCorrectLastItemByIndex() {
        fillStock();
        Product product = createProduct(3);
        stock.add(product);
        Product actual = stock.find(3);
        assertNotNull(actual);
        assertEquals(product.getLabel(), actual.getLabel());
    }

    @Test
    void testStockFindItemByIndexThrowsExForEmptyStock() {
        assertThrows(IndexOutOfBoundsException.class, () -> stock.find(0));
    }

    @Test
    void testStockFindItemByIndexThrowsExForBiggerThanExistingIndex() {
        fillStock();
        assertThrows(IndexOutOfBoundsException.class, () -> stock.find(3));
    }

    @Test
    void testStockChangeQuantityWorkingCorrectly() {
        Product product = createProduct(0);
        stock.add(product);
        stock.changeQuantity("Test_Label_1", 2);
        assertEquals(2, product.getQuantity());
    }

    @Test
    void testStockChangeQuantityWithNotExistingProductThrowsEx() {
        Product product = createProduct(0);
        stock.add(product);
        assertThrows(IllegalArgumentException.class, () ->
                stock.changeQuantity("Test_Label_7", 2));
    }

    @Test
    void testStockFindsTheCorrectItemByLabel() {
        Product expected = createProduct(3);
        stock.add(expected);
        fillStock();
        Product actual = stock.findByLabel("Test_Label_4");
        assertNotNull(actual);
        assertEquals(expected, actual);
    }

    @Test
    void testStockFindItemByLabelThrowsExForNotExistingLabel() {
        assertThrows(IllegalArgumentException.class, () -> stock.findByLabel("Not_Existing"));
    }

    @Test
    void testStockFindFirstByAlphabeticalOrder() {
        stock.add(createProduct(3));
        fillStock();
        Iterable<Product> firstByAlphabeticalOrder = stock.findFirstByAlphabeticalOrder(2);
        assertNotNull(firstByAlphabeticalOrder);
        List<Product> actualFirstByAlphabeticalOrder = getProducts(firstByAlphabeticalOrder);
        List<Product> expectedFirstByAlphabeticalOrder = List.of(createProduct(0),
                createProduct(1));

        for (int i = 0; i < expectedFirstByAlphabeticalOrder.size(); i++) {
            assertEquals(expectedFirstByAlphabeticalOrder.get(i).getLabel(),
                    actualFirstByAlphabeticalOrder.get(i).getLabel());
        }
    }

    @Test
    void testStockFindFirstByAlphabeticalOrderReturnsEmptyCollectionForNumberOfItemsMoreThanExisting() {
        stock.add(createProduct(3));
        fillStock();
        Iterable<Product> firstByAlphabeticalOrder = stock.findFirstByAlphabeticalOrder(5);
        assertNotNull(firstByAlphabeticalOrder);
        List<Product> products = getProducts(firstByAlphabeticalOrder);
        assertTrue(products.isEmpty());
    }

    @Test
    void testStockFindAllInPriceRangeWorkingCorrectly() {
        fillStock();
        stock.add(createProduct(3));
        Iterable<Product> actualFindAllInPriceRangeIterable = stock.findAllInPriceRange(12.0, 16.3);
        assertNotNull(actualFindAllInPriceRangeIterable);
        List<Product> actualFindAllInPriceRange = getProducts(actualFindAllInPriceRangeIterable);
        List<Product> expectedFindAllInPriceRange = List.of(createProduct(1),
                createProduct(3));

        assertEquals(expectedFindAllInPriceRange.size(), actualFindAllInPriceRange.size());

        for (int i = 0; i < expectedFindAllInPriceRange.size(); i++) {
            assertEquals(expectedFindAllInPriceRange.get(i).getLabel(),
                    actualFindAllInPriceRange.get(i).getLabel());
        }
    }

    @Test
    void testStockFindAllInRangeReturnsEmptyCollectionForNumberOfItemsMoreThanExisting() {
        stock.add(createProduct(3));
        fillStock();
        Iterable<Product> actualFindAllInPriceRangeIterable = stock.findAllInPriceRange(0.7, 2.3);
        assertNotNull(actualFindAllInPriceRangeIterable);
        List<Product> products = getProducts(actualFindAllInPriceRangeIterable);
        assertTrue(products.isEmpty());
    }

    @Test
    void testStockFindAllByPriceWorkingCorrectly() {
        fillStock();
        stock.add(createProduct(3));

        Iterable<Product> actualFindAllByPriceIterable = stock.findAllByPrice(15.5);
        assertNotNull(actualFindAllByPriceIterable);

        List<Product> actualFindAllByPrice = getProducts(actualFindAllByPriceIterable);
        List<Product> expectedFindAllByPrice = List.of(createProduct(1),
                createProduct(3));

        for (int i = 0; i < expectedFindAllByPrice.size(); i++) {
            assertEquals(expectedFindAllByPrice.get(i).getLabel(),
                    actualFindAllByPrice.get(i).getLabel());
        }
    }

    @Test
    void testStockFindAllByPriceReturnsEmptyCollectionForNothingFound() {
        fillStock();
        stock.add(createProduct(3));

        Iterable<Product> actualFindAllByPriceIterable = stock.findAllByPrice(3);
        assertNotNull(actualFindAllByPriceIterable);

        List<Product> actualFindAllByPrice = getProducts(actualFindAllByPriceIterable);
        assertTrue(actualFindAllByPrice.isEmpty());
    }

    @Test
    void findFirstMostExpensiveProducts() {
        fillStock();
        stock.add(createProduct(3));

        Iterable<Product> actualFirstMostExpensiveProductsIterable = stock.
                findFirstMostExpensiveProducts(3);
        assertNotNull(actualFirstMostExpensiveProductsIterable);

        List<Product> actualFirstMostExpensiveProducts = getProducts(
                actualFirstMostExpensiveProductsIterable);
        List<Product> expectedFirstMostExpensiveProducts = List.of(
                createProduct(2),
                createProduct(1),
                createProduct(3));

        for (int i = 0; i < expectedFirstMostExpensiveProducts.size(); i++) {
            assertEquals(expectedFirstMostExpensiveProducts.get(i).getLabel(),
                    actualFirstMostExpensiveProducts.get(i).getLabel());
        }
    }

    @Test
    void findFirstMostExpensiveProductsThrowsExForMoreItemsThanExisting() {
        fillStock();

        assertThrows(IllegalArgumentException.class, () -> stock.
                findFirstMostExpensiveProducts(4));
    }

    @Test
    void testFindAllByQuantityReturnsTheRightItems() {
        fillStock();
        stock.add(createProduct(3));

        Iterable<Product> actualFirstMostExpensiveProductsIterable = stock.
                findAllByQuantity(3);
        assertNotNull(actualFirstMostExpensiveProductsIterable);

        List<Product> actualFirstMostExpensiveProducts = getProducts(
                actualFirstMostExpensiveProductsIterable);
        List<Product> expectedFirstMostExpensiveProducts = List.of(createProduct(1),
                createProduct(3));

        for (int i = 0; i < expectedFirstMostExpensiveProducts.size(); i++) {
            assertEquals(expectedFirstMostExpensiveProducts.get(i).getLabel(),
                    actualFirstMostExpensiveProducts.get(i).getLabel());
        }
    }

    @Test
    void testFindAllByQuantityWithNoMatchReturnsEmptyCollection() {
        fillStock();
        stock.add(createProduct(3));

        Iterable<Product> actualFindAllByQuantityIterable = stock.findAllByQuantity(8);
        assertNotNull(actualFindAllByQuantityIterable);

        List<Product> actualFindAllByQuantity = getProducts(actualFindAllByQuantityIterable);
        assertTrue(actualFindAllByQuantity.isEmpty());
    }

    @Test
    void testGetAllItemsIterator() {
        fillStock();
        stock.add(createProduct(3));

        Iterator<Product> actualIterator = stock.iterator();
        assertNotNull(actualIterator);

        Iterator<Product> expectedIterator = List.of(createProduct(0),
                createProduct(1),
                createProduct(2),
                createProduct(3)).iterator();

        while (actualIterator.hasNext()) {
            Product actual = actualIterator.next();
            Product expected = expectedIterator.next();
            assertEquals(expected.getLabel(), actual.getLabel());
        }
    }

    private List<Product> getProducts(Iterable<Product> firstByAlphabeticalOrder) {
        List<Product> products = new ArrayList<>();

        for (Product product : firstByAlphabeticalOrder) {
            products.add(product);
        }

        return products;
    }

    private Product createProduct(int indexOfTheItem) {
        Product[] products = new Product[4];
        products[0] = new Product("Test_Label_1", 11.3, 1);
        products[1] = new Product("Test_Label_2", 15.5, 3);
        products[2] = new Product("Test_Label_3", 18.8, 5);
        products[3] = new Product("Test_Label_4", 15.5, 3);

        return products[indexOfTheItem];
    }

    //adds the first three items in the stock
    private void fillStock() {
        stock.add(createProduct(0));
        stock.add(createProduct(1));
        stock.add(createProduct(2));
    }
}