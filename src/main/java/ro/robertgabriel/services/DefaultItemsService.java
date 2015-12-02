package ro.robertgabriel.services;

import org.springframework.stereotype.Service;
import ro.robertgabriel.entities.Item;
import ro.robertgabriel.exceptions.EntityNotFoundException;
import ro.robertgabriel.repositories.ItemRepository;

import javax.inject.Inject;

@Service
public class DefaultItemsService implements ItemsService{

    @Inject
    private ItemRepository itemRepository;

    @Override
    public void save(Item item) {
        itemRepository.save(item);
    }

    @Override
    public Item findOneItem(String itemId) {
        Item item =   itemRepository.findOne(itemId);
        if (item == null){
            throw new EntityNotFoundException();
        }
        return item;
    }

    @Override
    public Iterable<Item> findByListId(String listId) {
        Iterable<Item> items =   itemRepository.findByListId(listId);
        if (!items.iterator().hasNext()){
            throw new EntityNotFoundException();
        }
        return items;
    }
}
