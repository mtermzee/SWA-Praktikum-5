package swa.flottenmanagement.entity.dto;

import swa.flottenmanagement.entity.Schiff;

public class SchiffDTO {
    private int id;
    private String name;
    private boolean isFree;

    public SchiffDTO() {
    }

    public SchiffDTO(Schiff other) {
        this.id = other.getId();
        this.name = other.getName();
        this.isFree = other.isFree();
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public boolean isFree() {
        return isFree;
    }

}
