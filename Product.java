package TradeTurnover;

class Product { // Класс товара
    private String id;            // Артикул товара
    private String name;          // Наименование товара
    private String category;      // Категория товара
    private double price; //  цена
    private int quantity;         // Количество на складе

    public Product(String id, String name, String category, double price, int quantity) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.price = price;
        this.quantity = quantity;
    }

    // Геттеры и сеттеры
    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public double getPrice() {
        return price;
    }


    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getInfo(){
        return ", ID: " + id +
                ", Name: " + name + ", Price: " + price + "Quantity" + quantity;

    }

    public void updateQuantity(int delta){
        if (this.quantity + delta < 0) {
            throw new IllegalArgumentException();
        }
        this.quantity += delta;
    }

}
