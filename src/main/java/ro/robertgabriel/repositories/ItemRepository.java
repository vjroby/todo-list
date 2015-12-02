package ro.robertgabriel.repositories;

import org.springframework.stereotype.Repository;
import ro.robertgabriel.entities.Item;

@Repository
public interface ItemRepository extends MyBaseRepository<Item, String> {
    Iterable<Item> findByListId(String listId);
}
