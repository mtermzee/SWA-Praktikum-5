package swa.flottenmanagement.entity;

import java.util.List;

public interface SchiffManagement {

    public Schiff getSchiff(int id);

    public List<Schiff> getSchiffs();

    public Schiff addSchiff(String name);

    public Schiff removeSchiff(int id);

    public Schiff updateSchiff(int id, String name);

    public List<Schiff> findAvailableSchiffs();

    public void setShipAvailability(int shipId, boolean isAvailable);
}
