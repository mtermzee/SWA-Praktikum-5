package swa.flottenmanagement.control;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Event;
import javax.enterprise.event.Observes;
import javax.inject.Inject;

import swa.auftragsmanagement.events.AddAuftrag;
import swa.auftragsmanagement.events.DeleteAuftrag;
import swa.flottenmanagement.entity.Schiff;
import swa.flottenmanagement.entity.SchiffManagement;
import swa.flottenmanagement.events.AuftragAngenommen;

import java.util.Optional;

@ApplicationScoped
public class SchiffService {
    @Inject
    SchiffManagement schiffManagement;

    @Inject
    Event<AuftragAngenommen> orderAcceptedEvent;

    public Schiff getSchiff(int id) {
        return schiffManagement.getSchiff(id);
    }

    public List<Schiff> getSchiffs() {
        return schiffManagement.getSchiffs();
    }

    public Schiff addSchiff(String name) {
        return schiffManagement.addSchiff(name);
    }

    public Schiff removeSchiff(int id) {
        return schiffManagement.removeSchiff(id);
    }

    public Schiff updateSchiff(int id, String name) {
        return schiffManagement.updateSchiff(id, name);
    }

    private Optional<Schiff> findAvailableShip()
    {
        return schiffManagement.findAvailableSchiffs().stream().findFirst();
    }

    private String buildShipURL(int shipId)
    {
        return "ship url with id: " + shipId;
    }

    private void reserveShip(int shipID)
    {
        schiffManagement.setShipAvailability(shipID, false);
    }

    private void freeShip(int shipId)
    {
        schiffManagement.setShipAvailability(shipId, true);
    }

    //Events

    private void OrderAdded(@Observes AddAuftrag orderPlaced)
    {
        Optional<Schiff> freeShip = findAvailableShip();

        if (freeShip.isPresent())
        {
            reserveShip(freeShip.get().getId());
            orderAcceptedEvent.fire(new AuftragAngenommen(orderPlaced.getOrderId(), buildShipURL(freeShip.get().getId())));
        }
    }

    private void OrderDeleted(@Observes DeleteAuftrag orderDeleted)
    {
        freeShip(orderDeleted.getShipId());
    }
}
