package models;

public class Category {
    private int id;
    private String name;

    public int getId() {
        return id;
    }

    public Category(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
