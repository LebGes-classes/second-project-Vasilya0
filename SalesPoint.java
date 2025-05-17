package TradeTurnover;

import java.util.*;

class SalesPoint implements ShowInfo{  // Класс пункта продаж
    private String pointId;       // Уникальный ID точки продаж
    private String address;       // Адрес точки
    private List<Product> products;
    // Товары в наличии
    private Employee cashier;     // Менеджер точки
    private boolean isActive;     // Флаг активности
    private double dailyRevenue;  // Дневная выручка

    public SalesPoint() {
        this.pointId = pointId;
        this.address = address;
        this.cashier = cashier;
        this.products = new ArrayList<>();
        this.isActive = true;
        this.dailyRevenue = 0;
    }

    public SalesPoint(String pointId, String address, Employee manager) {
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
        double totalCost = product.getPrice() * quantity;

        this.dailyRevenue += totalCost;

        product.quantity-=quantity;
        products.remove(product);
        return true;
    }

    public boolean acceptReturn(Product product, int quantity) {
        double totalCost = product.getPrice() * quantity;

        this.dailyRevenue -= totalCost;

        product.quantity+=quantity;
        products.add(product);
        return true;
    }

    public void closePoint(){
        this.isActive = false;
    }

    @Override
    public void showInfo() {  //Получает список всех товаров на пункте
        System.out.println(products.toString());
        System.out.println(dailyRevenue);

    }
}