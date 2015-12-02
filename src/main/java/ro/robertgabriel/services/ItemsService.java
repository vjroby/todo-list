package ro.robertgabriel.services;

import ro.robertgabriel.entities.Item;

public interface ItemsService {

    public void save(Item item);

    public Item findOneItem(String itemId);

    public Iterable<Item> findByListId(String listId);
}
