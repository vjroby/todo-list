package ro.robertgabriel.entities;

public class Dashboard {

    private long countTodoLists;
    private long countItems;
    private long countUsers;

    public long getCountTodoLists() {
        return countTodoLists;
    }

    public Dashboard setCountTodoLists(long countTodoLists) {
        this.countTodoLists = countTodoLists;
        return this;
    }

    public long getCountItems() {
        return countItems;
    }

    public Dashboard setCountItems(long countItems) {
        this.countItems = countItems;
        return this;
    }

    public long getCountUsers() {
        return countUsers;
    }

    public Dashboard setCountUsers(long countUsers) {
        this.countUsers = countUsers;
        return this;
    }
}
