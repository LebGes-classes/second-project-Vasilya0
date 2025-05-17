package TradeTurnover;

import java.util.*;

public class Company {
    private String name;             // Название компании
    private List<Employee> employees; // Список сотрудников
    private List<Customer> customers; // Список клиентов
    private List<Warehouse> warehouses; // Список складов
    private List<SalesPoint> salesPoints; // Список точек продаж
    private List<Product> productCatalog; // Каталог товаров
    //private Employee employee ;

    public Company(String name) {
        this.name = name;
        this.employees = new ArrayList<>();
        this.customers = new ArrayList<>();
        this.warehouses = new ArrayList<>();
        this.salesPoints = new ArrayList<>();
        this.productCatalog = new ArrayList<>();
    }

    //Уволить сотрудника
    public void fire(Employee employee){
        employee.setActive(false);
        employee.setPosition("Уволен");
    }

    //нанять нового сотрудника
    public Employee hire(String name, String id, String position, double salary) {
        Employee employee = new Employee(name, id, position, salary, true);
        employees.add(employee);
        return employee;
    }

    // Добавить товар в каталог
    public void addProductToCatalog(Product product) {
        productCatalog.add(product);
    }

    // Удалить товар из каталога
    public boolean removeProductFromCatalog(String productId) {
        Iterator<Product> iterator = productCatalog.iterator();
        while (iterator.hasNext()) {
            Product product = iterator.next();
            if (product.getId().equals(productId)) {
                iterator.remove();
                return true;
            }
        }
        return false;
    }

    //Открывает новый склад
    public void openWarehouse(Warehouse warehouse) {
        warehouses.add(warehouse);
    }

    //Закрывает склад по ID (деактивирует его)
    public void closeWarehouse(String warehouseId) {
        for (Warehouse warehouse : warehouses) {
            if (warehouse.getWarehouseId().equals(warehouseId)) {
                warehouse.setActive(false);
                break;
            }
        }
    }

    //Открывает новую точку продаж
    public void openSalesPoint(SalesPoint salesPoint) {
        salesPoints.add(salesPoint);
    }

    //Закрывает точку продаж по ID (деактивирует ее)
    public void closeSalesPoint(String pointId) {
        for (SalesPoint salesPoint : salesPoints) {
            if (salesPoint.getPointId().equals(pointId)) {
                salesPoint.setActive(false);
                break;
            }
        }
    }
}
