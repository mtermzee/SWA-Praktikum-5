package swa.flottenmanagement.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "Ships")
public class Schiff {
    @Id
    @SequenceGenerator(name = "shipSeq", sequenceName = "ship_id_seq", allocationSize = 1, initialValue = 1)
    @GeneratedValue(generator = "shipSeq")
    private int id;
    private String name;
    private boolean isFree;

    public Schiff() {

    }

    public Schiff(String name, boolean isFree) {
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
