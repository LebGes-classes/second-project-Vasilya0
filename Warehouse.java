package TradeTurnover;

import java.util.*;

class Warehouse implements ShowInfo{  // Класс склада
    private String warehouseId;    // Уникальный идентификатор склада
    private String address;        // Физический адрес склада
    private List<StorageCell> cells; // Список ячеек хранения
    private boolean isActive;      // Флаг активности склада
    private Employee manager;      // Менеджер склада
    //private Company company;

    public Warehouse(String warehouseId, String address, Employee manager) {
        this.warehouseId = warehouseId;
        this.address = address;
        this.manager = manager;
        this.cells = new ArrayList<>();
        this.isActive = true;
        //this.company = company;
    }

    public String getWarehouseId() {
        return warehouseId;
    }

    public String getAddress() {
        return address;
    }

    public List<StorageCell> getCells() {
        return cells;
    }

    public boolean isActive() {
        return isActive;
    }

    public Employee getManager() {
        return manager;
    }

    public void setManager(Employee manager) {
        this.manager = manager;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public void addCell(StorageCell cell) {
        cells.add(cell);
    } //Добавляет новую ячейку хранения

    public void removeCell(String cellId) {  //Удаляет ячейку по идентификатору
        Iterator<StorageCell> iterator = cells.iterator();
        while (iterator.hasNext()) {
            StorageCell cell = iterator.next();
            if (cell.getCellId().equals(cellId)) {
                iterator.remove();
                break; // если нужно удалить только первую найденную ячейку с таким ID
            }
        }
    }

    public StorageCell findCell(String cellId) {  //поиск ячейки по ID
        for (StorageCell cell : cells) {
            if (cell.getCellId().equals(cellId)) {
                return cell;
            }
        }
        return null;
    }


    public void changeManager(Employee newManager) {
        if (!newManager.isActive()) {
            throw new IllegalArgumentException();
        }
        this.manager = newManager;

    }
    public void closeWarehouse() throws IllegalStateException {
        // Проверяем все ячейки на наличие товаров
        for (StorageCell cell : cells) {
            if (cell.getCurrentQuantity() > 0) {
                throw new IllegalStateException();
            }
        }
        // Если склад пуст - закрываем
        this.isActive = false;
    }

    @Override
    public void showInfo() {
        System.out.println("Warehouse ID: " + warehouseId);
        System.out.println("Address: " + address);
        System.out.println("Manager: " + manager.getName());
        System.out.println("Active: " + isActive);
        System.out.println("Storage cells content:");

        for (StorageCell cell : cells) {
            if (cell.getProduct() != null) {
                System.out.println("Cell " + cell.getCellId() + ": " +
                        cell.getProduct().getInfo() +
                        " (Qty: " + cell.getCurrentQuantity() + ")");
            }
        }
    }
}
