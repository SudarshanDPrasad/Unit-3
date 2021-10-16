package com.example.rxjava.assignement;

public class Students {
    private int id;
    private int marsks;

    public Students(int id, int marsks) {
        this.id = id;
        this.marsks = marsks;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMarsks() {
        return marsks;
    }

    public void setMarsks(int marsks) {
        this.marsks = marsks;
    }
}
