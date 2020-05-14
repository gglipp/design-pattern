package com.panlijun.model;

public class MyData {
    private int id;
    private String name;

    @Override
    public String toString() {
        return "MyData{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    public MyData(int id) {
        this.id = id;
    }

    public MyData() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
