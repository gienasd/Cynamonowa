package controller;

import service.ItemService;

public class ItemController {
    public static void main(String[] args) {
        ItemService itemService = new ItemService();

        // all items from Ikea
        System.out.println("Items which you will buy in Ikea: "
                + itemService.filterByIkeaList());
    }
}
