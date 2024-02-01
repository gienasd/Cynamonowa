package service;

import dao.ItemDao;
import entities.Item;
import entities.KindOfItem;
import entities.Room;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class ItemService {
    private final ItemDao itemDao = new ItemDao();

    public List<Item> filterByIkeaList() {
        return itemDao.getShopList().stream()
                .filter(item -> item.getShop().equalsIgnoreCase("Ikea"))
                .toList();
    }

    public List<Item> filterByKitchenList() {
        return itemDao.getShopList().stream()
                .filter(item -> Room.KITCHEN.equals(item.getRoom()))
                .toList();
    }

    public List<Item> filterByPriceMoreThan(double price) {
        return itemDao.getShopList().stream()
                .filter(item -> item.getCost() > price)
                .toList();
    }

    public double getCostOfItemsFromIkea() {
        return itemDao.getShopList().stream()
                .filter(item -> item.getShop().equalsIgnoreCase("Ikea"))
                .mapToDouble(Item::getCost)
                .sum();
    }

    public List<Item> filterByCastoramaList() {
        return itemDao.getShopList().stream()
                .filter(item -> item.getShop().equalsIgnoreCase("Castorama"))
                .filter(item -> KindOfItem.TOOL.equals(item.getKindOfItem()))
                .toList();
    }

    public List<Item> filterByCountMoreThanOneList() {
        return itemDao.getShopList().stream()
                .filter(item -> item.getCount() > 1)
                .toList();
    }

    public List<Item> getRestList() {
        List<Item> restList = new ArrayList<>(itemDao.getShopList());
        restList.removeAll(getAllFilteredItems());
        return restList;

    }

    private HashSet<Item> getAllFilteredItems() {
        HashSet<Item> allUsedItems = new HashSet<>();
        allUsedItems.addAll(filterByIkeaList());
        allUsedItems.addAll(filterByCountMoreThanOneList());
        allUsedItems.addAll(filterByCastoramaList());
        allUsedItems.addAll(filterByKitchenList());
        return allUsedItems;
    }
}
