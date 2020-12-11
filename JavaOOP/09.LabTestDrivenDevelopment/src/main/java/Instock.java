import java.util.*;
import java.util.stream.Collectors;

public class Instock implements ProductStock {

    private final Map<String, Product> products = new LinkedHashMap<>();

    @Override
    public int getCount() {
        return products.size();
    }

    @Override
    public boolean contains(Product product) {
        return products.values().stream().anyMatch(p -> p == product);
    }

    @Override
    public void add(Product product) {
        products.putIfAbsent(product.getLabel(), product);
    }

    @Override
    public void changeQuantity(String product, int quantity) {
        if (!products.containsKey(product)) {
            throw new IllegalArgumentException("There is no product with such name.");
        }

        products.get(product).setQuantity(quantity);
    }

    @Override
    public Product find(int index) {
        return new ArrayList<>(products.values()).get(index);
    }

    @Override
    public Product findByLabel(String label) {
        if (!products.containsKey(label)) {
            throw new IllegalArgumentException("There is no product with such name in the collection.");
        }

        return products.get(label);
    }

    @Override
    public Iterable<Product> findFirstByAlphabeticalOrder(int count) {
        if (count > products.size()) {
            return new ArrayList<>();
        }

        return products.values()
                .stream()
                .sorted()
                .limit(count)
                .collect(Collectors.toList());
    }

    @Override
    public Iterable<Product> findAllInPriceRange(double lo, double hi) {
        List<Product> productList = new ArrayList<>();
        for (Product product : products.values()) {
            if (product.getPrice() > lo && product.getPrice() <= hi) {
                productList.add(product);
            }
        }

        return productList.stream()
                .sorted((f, s)-> Double.compare(s.getPrice(),
                        f.getPrice())).collect(Collectors.toList());
    }

    @Override
    public Iterable<Product> findAllByPrice(double price) {
        List<Product> productList = new ArrayList<>();

        for (Product product : products.values()) {
            if (product.getPrice() == price) {
                productList.add(product);
            }
        }

        return productList.stream()
                .sorted((f, s)-> Double.compare(s.getPrice(),
                        f.getPrice())).collect(Collectors.toList());
    }

    @Override
    public Iterable<Product> findFirstMostExpensiveProducts(int count) {
        if (count > products.size()) {
            throw new IllegalArgumentException("There are not that many products in the stock.");
        }

        return products.values()
                .stream()
                .sorted((f, s) -> Double.compare(s.getPrice(), f.getPrice()))
                .limit(count)
                .collect(Collectors.toList());
    }

    @Override
    public Iterable<Product> findAllByQuantity(int quantity) {
        return products.values()
                .stream()
                .filter(p -> p.getQuantity() == quantity)
                .collect(Collectors.toList());
    }

    @Override
    public Iterator<Product> iterator() {
        return products.values().iterator();
    }
}
