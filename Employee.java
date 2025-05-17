package TradeTurnover;

public class Employee extends Person{ // Класс работника компании
    private String position;  // Должность сотрудника
    private double salary;    // Зарплата сотрудника
    private boolean isActive; // Флаг активности (работает/уволен)
    private String name;
    private String id;

    public Employee(String name, String id, String position, double salary, boolean isActive) {
        super(name, id);
        this.position = position;
        this.salary = salary;
        this.isActive = true;

    }

    public String getPosition() {
        return position;
    }

    public double getSalary() {
        return salary;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        this.isActive = active;
    }

    public void setPosition(String position) {
        this.position = position;
    }
    public void setSalary(double salary) {
        this.salary = salary;
    }

    public void setName(String name) {
        this.name = name;
    }
}
