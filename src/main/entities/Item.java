package entities;

public class Item {

    private String name;
    private double cost;
    private String shop;
    private int count;
    private KindOfItem kindOfItem;
    private Room room;

    public Item() {
    }

    public Item(String name, double cost, String shop, int count, KindOfItem kindOfItem, Room room) {
        this.name = name;
        this.cost = cost;
        this.shop = shop;
        this.count = count;
        this.kindOfItem = kindOfItem;
        this.room = room;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public String getShop() {
        return shop;
    }

    public void setShop(String shop) {
        this.shop = shop;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public KindOfItem getKindOfItem() {
        return kindOfItem;
    }

    public void setKindOfItem(KindOfItem kindOfItem) {
        this.kindOfItem = kindOfItem;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    @Override
    public String toString() {
        return "Item{" +
                "Nazwa='" + name + '\'' +
                ", koszt=" + cost +
                ", sklep='" + shop + '\'' +
                ", ilość=" + count +
                ", rodzaj=" + kindOfItem +
                ", pokój=" + (room != null ? room : "Brak") +
                '}';
    }
}
