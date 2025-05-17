package TradeTurnover;

class StorageCell { // Класс ячейки склада
    private String cellId;         // Уникальный идентификатор ячейки
    private Product product;       // Товар, хранящийся в ячейке (null если ячейка пуста)
    private int capacity;          // Максимальная вместимость ячейки (в единицах товара)
    private Employee responsible; // Ответственный сотрудник за ячейку
    private int currentQuantity;  //текущее количество товара

    public StorageCell(String cellId, int capacity) {
        this.cellId = cellId;
        this.capacity = capacity;
    }

    public String getCellId() {
        return cellId;
    }

    public Product getProduct() {
        return product;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getCurrentQuantity() {
        return currentQuantity;
    }

    public Employee getResponsible() {
        return responsible;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public void addProduct(int quantity) {
        if (this.currentQuantity + quantity > this.capacity) {
            throw new IllegalStateException();
        }
        this.currentQuantity += quantity;
    }

    public void removeProduct(int quantity){
        if (this.currentQuantity + quantity < this.capacity) {
            throw new IllegalStateException();
        }
        this.currentQuantity -= quantity;
    }

    public boolean isFull(){
        return this.currentQuantity >= this.capacity;
    }

}