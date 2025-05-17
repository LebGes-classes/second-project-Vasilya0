package TradeTurnover;

import java.util.ArrayList;
import java.util.List;

class Customer extends Person{  // Класс покупателя

    private String name;
    private String id;
    private double money;
    private List<Product> purchases = new ArrayList<>();
    private SalesPoint products = new  SalesPoint();


    public Customer(String name, String id, double money) {
        super(name, id);
        this.money = money;
    }



    public double getMoney() {
        return money;
    }

    public List<Product> getPurchases() { return purchases; }


    public boolean buy(SalesPoint point, Product product, int quantity){
        double totalCost = product.getPrice() * quantity;
        if (totalCost > this.money) {
            System.out.println("Недостаточно денег для покупки");
            return false;
        }
        this.money -= totalCost;

        purchases.add(product);
        product.quantity-=quantity;
        products.getProducts().remove(product);
        return true;
    }

    public boolean returnProduct(SalesPoint point, Product product, int quantity) {
        this.money += product.getPrice();
        purchases.remove(product);
        product.quantity += quantity;
        products.getProducts().add(product);
        return true;
    }



}
