package cn.kdoa.entity;

public class Users {
    private int id;
    private String name;

    public Users() {
    }

    public Users(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
