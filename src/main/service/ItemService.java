package service;

import dao.ItemDao;
import entities.Item;
import entities.KindOfItem;
import entities.Room;

import java.util.List;

public class ItemService {
    private final ItemDao itemDao = new ItemDao();

    public List<Item> getItemsByShopName(String shopName) {
        return itemDao.getShopList().stream()
                .filter(item -> item.getShop().equalsIgnoreCase(shopName))
                .toList();
    }

    public List<Item> getItemsByRoom(Room room) {
        return itemDao.getShopList().stream()
                .filter(item -> room.equals(item.getRoom()))
                .toList();
    }

    public List<Item> getItemsByPriceMoreThan(double price) {
        return itemDao.getShopList().stream()
                .filter(item -> item.getCost() > price)
                .toList();
    }

    public double getCostOfItemsFromGivenShop(String shopName) {
        return getItemsByShopName(shopName).stream()
                .mapToDouble(Item::getCost)
                .sum();
    }

    public List<Item> getItemsFromGivenShopWithGivenKind(String shopName, KindOfItem kindOfItem) {
        return getItemsByShopName(shopName).stream()
                .filter(item -> kindOfItem.equals(item.getKindOfItem()))
                .toList();
    }

    public List<Item> getItemsWithCountMoreThan(int count) {
        return itemDao.getShopList().stream()
                .filter(item -> item.getCount() > count)
                .toList();
    }
}
