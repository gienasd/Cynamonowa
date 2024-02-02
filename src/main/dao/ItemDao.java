package dao;

import entities.Item;
import entities.KindOfItem;
import entities.Room;

import java.util.ArrayList;
import java.util.List;

public class ItemDao {
    private final List<Item> itemList = new ArrayList<>(setupItemList());

    public List<Item> getShopList() {
        return itemList;
    }

    public void addItemToList(final Item item) {
        checkIfItemAlreadyExists();
        itemList.add(item);
    }

    //TODO: Dopisz metody, które updatują item, usuwają item, usuwają wiele itemów, (w przypadkach usuwania może warto sprawdzić jego 'count'? może usuwamy 3 sztuki, a w liście jest 5?)
    // dodają wiele itemów (w ostatnim przypadku ze sprawdzaniem checkIfItemAlreadyExists, jak w przypadku dodawania pojedynczego itemu)

    private void checkIfItemAlreadyExists() {
        //TODO: Dopisać metodę, w której sprawdzisz, czy dany Item jest już w ShopLiście, a jeżeli jest to zwiększysz mu 'count' o 'count' itemu, który sprawdzamy
        // a jeśli nie ma to zrób 'break;'
    }

    private List<Item> setupItemList() {
        Item induction = new Item("induction_Bosh", "media_markt", 1299, 1, KindOfItem.OTHER, Room.KITCHEN);
        Item table = new Item("dinner_table", "Ikea", 799, 1, KindOfItem.FURNITURE, Room.LIVINGROOM);
        Item oven = new Item("Oven_Bosh", "media_markt", 1399, 1, KindOfItem.OTHER, Room.KITCHEN);
        Item chair = new Item("dinner_chairs", "Ikea", 199, 4, KindOfItem.FURNITURE, Room.LIVINGROOM);
        Item bed = new Item("big_bed", "Bodzio", 1900, 1, KindOfItem.FURNITURE, Room.BEDROOM);
        Item stairs = new Item("house_stairs", "mr. Schodziarz", 23000, 1, KindOfItem.OTHER, Room.LIVINGROOM);
        Item hammer = new Item("hammer_tool", "Castorama", 18, 2, KindOfItem.TOOL, null);
        Item glue = new Item("wood_glue", "OBI", 7, 5, KindOfItem.TOOL, null);
        Item screw = new Item("small_screw", "OBI", 1, 100, KindOfItem.TOOL, null);
        Item secondMonitor = new Item("Monitor", "X-Kom", 700, 1, KindOfItem.OTHER, Room.DAMIANS_CAVE);

        ArrayList<Item> shopList = new ArrayList<>();
        shopList.add(induction);
        shopList.add(table);
        shopList.add(oven);
        shopList.add(chair);
        shopList.add(bed);
        shopList.add(stairs);
        shopList.add(hammer);
        shopList.add(glue);
        shopList.add(screw);
        shopList.add(secondMonitor);
        return shopList;
    }
}
