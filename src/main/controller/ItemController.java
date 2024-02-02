package controller;

import entities.KindOfItem;
import entities.Room;
import service.ItemService;

public class ItemController {
    public static void main(String[] args) {
        ItemService itemService = new ItemService();

        // all items from Ikea
        System.out.println("Items which you will buy in Ikea: "
                + itemService.getItemsByShopName("Ikea"));

        // all items in kitchen
        System.out.println("Items which you will keep in Kitchen: "
                + itemService.getItemsByRoom(Room.KITCHEN));

        // cost is more than 1000 PLN
        System.out.println("Items which you will buy for more than 1000PL: "
                + itemService.getItemsByPriceMoreThan(1000));

        //Cost in Ikea
        System.out.println("In Ikea you will spend: "
                + itemService.getCostOfItemsFromGivenShop("Ikea"));

        // tools from Castorama
        System.out.println("Tools which you will buy in Castorama: "
                + itemService.getItemsFromGivenShopWithGivenKind("Castorama", KindOfItem.TOOL));

        // more than one piece of item
        System.out.println("Items which you will buy more than one piece: "
                + itemService.getItemsWithCountMoreThan(1));
    }
}
