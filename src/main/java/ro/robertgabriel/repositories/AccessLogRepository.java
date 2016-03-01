package ro.robertgabriel.repositories;

import ro.robertgabriel.entities.AccessLog;

import java.util.List;

public interface AccessLogRepository extends MyBaseRepository<AccessLog, String> {


    List<AccessLog> findAllOrderByRequestTimeDesc();
}
