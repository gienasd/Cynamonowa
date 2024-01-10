import entities.Item;
import entities.KindOfItem;
import entities.Room;

public class Main {
    public static void main(String[] args) {
        Item wardrobe = new Item("Szafa trzydrzwiowa", 1999.99, "Ikea", 1, KindOfItem.FURNITURE, Room.SLEEPING_ROOM);
        Item table = new Item("Stół jadalny", 3500.00, "Ikea", 1, KindOfItem.FURNITURE, Room.KITCHEN);
        Item chair = new Item("Krzesło do stołu jadalnego", 350.00, "Komfort", 4, KindOfItem.FURNITURE, Room.KITCHEN);

        Item screwdriver = new Item();
        screwdriver.setName("Śrubokręt");
        screwdriver.setCost(59.99);
        screwdriver.setShop("Castorama");
        screwdriver.setCount(2);
        screwdriver.setKindOfItem(KindOfItem.TOOL);
        screwdriver.setRoom(null);

        System.out.println(screwdriver);
    }
}
