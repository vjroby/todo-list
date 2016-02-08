package ro.robertgabriel.repositories;

import org.springframework.stereotype.Repository;
import ro.robertgabriel.entities.Item;

import java.util.List;

@Repository
public interface ItemRepository extends MyBaseRepository<Item, String> {
    List<Item> findByListId(String listId);
}
