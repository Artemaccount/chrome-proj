public class Item {
    String name;
    String price;

    public Item(String name, String price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Наименование: " + name + "| Стоимость: " + price;
    }
}
