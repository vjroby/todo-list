package ro.robertgabriel.repositories;


import org.springframework.data.repository.CrudRepository;

import java.io.Serializable;

interface MyBaseRepository<T,ID extends Serializable> extends CrudRepository<T,ID> {
}
