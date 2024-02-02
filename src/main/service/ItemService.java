package service;

import dao.ItemDao;
import entities.Item;
import entities.KindOfItem;
import entities.Room;

import java.util.List;

public class ItemService {
    private final ItemDao itemDao = new ItemDao();

    public List<Item> getItemsByShopName(final String shopName) {
        return itemDao.getShopList().stream()
                .filter(item -> item.getShop().equalsIgnoreCase(shopName))
                .toList();
    }

    public List<Item> getItemsByRoom(final Room room) {
        return itemDao.getShopList().stream()
                .filter(item -> room.equals(item.getRoom()))
                .toList();
    }

    public List<Item> getItemsByPriceMoreThan(final double price) {
        return itemDao.getShopList().stream()
                .filter(item -> item.getCost() > price)
                .toList();
    }

    public double getCostOfItemsFromShop(final String shopName) {
        return getItemsByShopName(shopName).stream()
                .mapToDouble(Item::getCost)
                .sum();
    }

    public List<Item> getItemsFromShopWithKind(final String shopName, final KindOfItem kindOfItem) {
        return getItemsByShopName(shopName).stream()
                .filter(item -> kindOfItem.equals(item.getKindOfItem()))
                .toList();
    }

    public List<Item> getItemsWithCountMoreThan(final int count) {
        return itemDao.getShopList().stream()
                .filter(item -> item.getCount() > count)
                .toList();
    }
}
