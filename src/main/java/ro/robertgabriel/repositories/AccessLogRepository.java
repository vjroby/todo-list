package ro.robertgabriel.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import ro.robertgabriel.entities.AccessLog;

import java.util.List;

@Repository
public interface AccessLogRepository extends PagingAndSortingRepository<AccessLog, String> {

    List<AccessLog> findAll();
}
