import entities.Item;
import entities.KindOfItem;
import entities.Room;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        ArrayList<Item> shopList = setupItems();

        // all items in kitchen
        List<Item> filteredbyKitchenList = shopList.stream()
                .filter(item -> Room.KITCHEN.equals(item.getRoom()))
                .toList();
        System.out.println("Items which you will keep in Kitchen: "
                + filteredbyKitchenList);

        // cost is more than 1000 PLN
        List<Item> filteredby1000PLNList = shopList.stream()
                .filter(item -> item.getCost() > 1000)
                .toList();
        System.out.println("Items which you will buy for more than 1000PL: "
                + filteredby1000PLNList);

        //Cost in Ikea
        double ikeaCost = shopList.stream()
                .filter(item -> item.getShop().equalsIgnoreCase("Ikea"))
                .mapToDouble(Item::getCost)
                .sum();
        System.out.println("In Ikea you will spend: "
                + ikeaCost);

        // tools from Castorama
        List<Item> filteredbyCastoramaList = shopList.stream()
                .filter(item -> item.getShop().equalsIgnoreCase("Castorama"))
                .filter(item -> KindOfItem.TOOL.equals(item.getKindOfItem()))
                .toList();
        System.out.println("Tools which you will buy in Castorama: "
                + filteredbyCastoramaList);

        // more than one piece of item
        List<Item> filteredbyCountMoreThanOneList = shopList.stream()
                .filter(item -> item.getCount() > 1)
                .toList();
        System.out.println("Items which you will buy more than one piece: "
                + filteredbyCountMoreThanOneList);

        // else items with we will buy
        HashSet<Item> allUsedItems = new HashSet<>();
        allUsedItems.addAll(filteredby1000PLNList);
        allUsedItems.addAll(filteredbyCountMoreThanOneList);
        allUsedItems.addAll(filteredbyCastoramaList);
        allUsedItems.addAll(filteredbyKitchenList);

        List<Item> restList = new ArrayList<>(shopList);
        restList.removeAll(allUsedItems);
        System.out.println("Rest of the items: " + restList);
    }

    private static ArrayList<Item> setupItems() {
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
