package ro.robertgabriel.services;

import ro.robertgabriel.entities.Dashboard;

public interface DashboardService {
    long countTodoLists();

    long countItems();

    long countUsers();

    Dashboard getDashboardContent();
}
