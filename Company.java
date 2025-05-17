package TradeTurnover;

import java.io.*;
import java.util.*;
import java.time.LocalDate;

public class Company {
    private String name;             // Название компании
    private List<Employee> employees; // Список сотрудников
    private List<Customer> customers; // Список клиентов
    private List<Warehouse> warehouses; // Список складов
    private List<SalesPoint> salesPoints; // Список точек продаж
    private List<Product> productCatalog; // Каталог товаров
    private Employee employee ;

    public Company(String name) {
        this.name = name;
        this.employees = new ArrayList<>();
        this.customers = new ArrayList<>();
        this.warehouses = new ArrayList<>();
        this.salesPoints = new ArrayList<>();
        this.productCatalog = new ArrayList<>();
    }

    //Уволить сотрудника
    public void fire(){
        employee.setActive(false);
        employee.setPosition("Уволен");
    }

    //нанять нового сотрудника
    public void hire(String name, String position, double salary){
        employee.setName(name);
        employee.setPosition(position);
        employee.setSalary(salary);
        employee.setActive(true);
        employees.add(employee);
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



////Перемещение товара
//Смена ответственного лица
////Товар по продаже
////Возврат товара
//Закупка товара
////Naim employee
////Увольнение сотрудника
////Открытие нового склада
////Закрытие склада
////Открытие пункта продаж
////Закрытие точки продаж
//Информация о складе/пунктах продаж
//Информация о товарах на складе/пунктах продаж
//Информация о товарах, доступных для закупки
//Информация о доходности предприятия/пункта продаж