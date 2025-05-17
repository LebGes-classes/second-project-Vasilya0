package TradeTurnover;

import java.util.*;

class SalesPoint implements ShowInfo{  // Класс пункта продаж
    private String pointId;       // Уникальный ID точки продаж
    private String address;       // Адрес точки
    private List<Product> products; // Товары в наличии
    private Employee cashier;     // Менеджер точки
    private boolean isActive;     // Флаг активности
    private double dailyRevenue;  // Дневная выручка

    public SalesPoint() {
        this.pointId = "";
        this.address = "";
        this.cashier = null;
        this.products = new ArrayList<>();
        this.isActive = true;
        this.dailyRevenue = 0;
    }

    public SalesPoint(String pointId, String address, Employee cashier) {
        this.pointId = pointId;
        this.address = address;
        this.cashier = cashier;
        this.products = new ArrayList<>();
        this.isActive = true;
        this.dailyRevenue = 0;
    }

    public String getPointId() {
        return pointId;
    }

    public String getAddress() {
        return address;
    }

    public List<Product> getProducts() {
        return products;
    }

    public Employee getCashier() {
        return cashier;
    }

    public boolean isActive() {
        return isActive;
    }

    public double getDailyRevenue() {
        return dailyRevenue;
    }

    public void setCashier(Employee cashier) {
        this.cashier = cashier;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public boolean sellProduct(Product product, int quantity){
        if (!products.contains(product) || product.getQuantity() < quantity) {
            return false;
        }

        double totalCost = product.getPrice() * quantity;
        this.dailyRevenue += totalCost;
        product.updateQuantity(-quantity);

        // Если товар закончился, удаляем его из списка
        if (product.getQuantity() == 0) {
            products.remove(product);
        }
        return true;
    }

    public boolean acceptReturn(Product product, int quantity) {
        double totalCost = product.getPrice() * quantity;
        this.dailyRevenue -= totalCost;

        if (products.contains(product)) {
            product.updateQuantity(quantity);
        } else {
            Product returnedProduct = new Product(product.getId(), product.getName(),
                    product.getCategory(), product.getPrice(), quantity);
            products.add(returnedProduct);
        }
        return true;
    }

    public void closePoint(){
        this.isActive = false;
    }

    @Override
    public void showInfo() {  //Получает список всех товаров на пункте
        System.out.println("Товары на точке продаж " + pointId + ":");
        for (Product product : products) {
            System.out.println(product.getInfo());
        }
        System.out.println("Дневная выручка: " + dailyRevenue);

    }
}
