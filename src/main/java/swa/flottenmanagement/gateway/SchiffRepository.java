package swa.flottenmanagement.gateway;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.enterprise.context.ApplicationScoped;

import swa.flottenmanagement.entity.Schiff;
import swa.flottenmanagement.entity.SchiffManagement;

@ApplicationScoped
public class SchiffRepository implements SchiffManagement {
    Map<Integer, Schiff> ships = new HashMap<>();
    int nextAvailabaleID = 0;

    @Override
    public Schiff getSchiff(int id) {
        if (ships.containsKey(id))
            return ships.get(id);
        return null;
    }

    @Override
    public List<Schiff> getSchiffs() {
        return List.copyOf(ships.values());
    }

    @Override
    public Schiff addSchiff(String name) {
        if (name != "") {
            Schiff ship = new Schiff(nextAvailabaleID++, name, true);
            ships.put(ship.getId(), ship);
            return ship;
        }
        return null;
    }

    @Override
    public Schiff removeSchiff(int id) {
        if (ships.containsKey(id)) {
            Schiff ship = ships.get(id);
            ships.remove(id);
            return ship;
        }
        return null;
    }

    @Override
    public Schiff updateSchiff(int id, String name) {
        if (ships.containsKey(id)) {
            Schiff ship = ships.get(id);
            ship.setName(name);
            return ship;
        }
        return null;
    }

}
