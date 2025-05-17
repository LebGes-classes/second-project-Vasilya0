package TradeTurnover;

import java.util.ArrayList;
import java.util.List;

class Customer extends Person{  // Класс покупателя

    private double money;
    private List<Product> purchases = new ArrayList<>();
    //private SalesPoint products = new  SalesPoint();


    public Customer(String name, String id, double money) {
        super(name, id);
        this.money = money;
    }



    public double getMoney() {
        return money;
    }

    public List<Product> getPurchases() { return purchases; }


    public boolean buy(SalesPoint point, Product product, int quantity) {
        if (!point.getProducts().contains(product) || product.getQuantity() < quantity) {
            System.out.println("Товар недоступен в указанном количестве");
            return false;
        }

        double totalCost = product.getPrice() * quantity;
        if (totalCost > this.money) {
            System.out.println("Недостаточно денег для покупки");
            return false;
        }

        this.money -= totalCost;
        point.sellProduct(product, quantity);

        // Добавляем купленный товар в список покупок
        Product purchasedProduct = new Product(product.getId(), product.getName(),
                product.getCategory(), product.getPrice(), quantity);
        purchases.add(purchasedProduct);
        return true;
    }

    public boolean returnProduct(SalesPoint point, Product product, int quantity) {
        if (!purchases.contains(product)) {
            System.out.println("Этот товар не был куплен");
            return false;
        }

        this.money += product.getPrice() * quantity;
        point.acceptReturn(product, quantity);
        purchases.remove(product);
        return true;
    }
}
