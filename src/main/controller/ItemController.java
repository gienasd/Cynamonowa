package controller;

import service.ItemService;

public class ItemController {
    public static void main(String[] args) {
        ItemService itemService = new ItemService();

        // all items from Ikea
        System.out.println("Items which you will buy in Ikea: "
                + itemService.filterByIkeaList());

        // all items in kitchen
        System.out.println("Items which you will keep in Kitchen: "
                + itemService.filterByKitchenList());

        // cost is more than 1000 PLN
        System.out.println("Items which you will buy for more than 1000PL: "
                + itemService.filterByPriceMoreThan(1000d));

        //Cost in Ikea
        System.out.println("In Ikea you will spend: "
                + itemService.getCostOfItemsFromIkea());

        // tools from Castorama
        System.out.println("Tools which you will buy in Castorama: "
                + itemService.filterByCastoramaList());

        // more than one piece of item
        System.out.println("Items which you will buy more than one piece: "
                + itemService.filterByCountMoreThanOneList());

        // else items with we will buy
        System.out.println("Rest of the items: " + itemService.getRestList());

    }
}
