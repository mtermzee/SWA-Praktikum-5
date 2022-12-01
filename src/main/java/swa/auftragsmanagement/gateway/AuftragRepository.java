package swa.auftragsmanagement.gateway;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.enterprise.context.ApplicationScoped;

import swa.auftragsmanagement.entity.Auftrag;
import swa.auftragsmanagement.entity.AuftragManagement;

@ApplicationScoped
public class AuftragRepository implements AuftragManagement {
    Map<Integer, Auftrag> orders = new HashMap<>();
    int nextAvailabaleID = 0;

    @Override
    public Auftrag getAuftragByID(int id) {
        if (orders.containsKey(id))
            return orders.get(id);
        return null;
    }

    @Override
    public List<Auftrag> getAuftrags() {
        System.out.println(List.copyOf(orders.values()));
        return List.copyOf(orders.values());
    }

    @Override
    public Auftrag addAuftrag(String description) {
        if (description != "") {
            Auftrag order = new Auftrag(nextAvailabaleID++, description, "data", "Schiff");
            orders.put(order.getId(), order);
            return order;
        }
        return null;
    }

    @Override
    public Auftrag updateAuftrag(int id, String description) {
        if (orders.containsKey(id)) {
            Auftrag order = orders.get(id);
            order.setDescription(description);
            return order;
        }
        return null;
    }

    @Override
    public Auftrag deleteAuftrag(int id) {
        if (orders.containsKey(id)) {
            Auftrag order = orders.get(id);
            orders.remove(id);
            return order;
        }
        return null;
    }

}
