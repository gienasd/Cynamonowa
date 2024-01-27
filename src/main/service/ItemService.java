package service;

import dao.ItemDao;
import entities.Item;

import java.util.List;

public class ItemService {
    private final ItemDao itemDao = new ItemDao();

    public List<Item> filterByIkeaList() {
        return itemDao.getShopList().stream()
                .filter(item -> item.getShop().equalsIgnoreCase("Ikea"))
                .toList();
    }
}
