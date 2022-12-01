package swa.flottenmanagement.entity;

public class Schiff {
    private int id;
    private String name;
    private boolean isFree;

    public Schiff() {

    }

    public Schiff(int id, String name, boolean isFree) {
        this.id = id;
        this.name = name;
        this.isFree = isFree;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isFree() {
        return isFree;
    }

    public void setFree(boolean isFree) {
        this.isFree = isFree;
    }

}
