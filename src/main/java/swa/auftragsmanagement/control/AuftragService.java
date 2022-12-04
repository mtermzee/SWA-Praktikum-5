package swa.auftragsmanagement.control;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Event;
import javax.enterprise.event.Observes;
import javax.inject.Inject;

import swa.auftragsmanagement.entity.Auftrag;
import swa.auftragsmanagement.entity.AuftragManagement;
import swa.auftragsmanagement.events.AddAuftrag;
import swa.auftragsmanagement.events.DeleteAuftrag;
import swa.auftragsmanagement.events.UpdateAuftrag;
import swa.flottenmanagement.events.AuftragAngenommen;

@ApplicationScoped
public class AuftragService {
    @Inject
    AuftragManagement auftragManagement;

    @Inject
    Event<AddAuftrag> orderPlacedEvent;

    @Inject
    Event<DeleteAuftrag> orderDeleteEvent;

    @Inject
    Event<UpdateAuftrag> orderUpdateEvent;

    public Auftrag getAuftragByID(int id) {
        return auftragManagement.getAuftragByID(id);
    }

    public List<Auftrag> getAuftrags() {
        return auftragManagement.getAuftrags();
    }

    public Auftrag addAuftrag(String description) {
        Auftrag auftrag = auftragManagement.addAuftrag(description);
        orderPlacedEvent.fire(new AddAuftrag(auftrag.getId()));
        return auftrag;
    }

    public Auftrag updateAuftrag(int id, String description) {
        Auftrag updatedOrder = auftragManagement.updateAuftrag(id, description);
        orderUpdateEvent.fire(new UpdateAuftrag(id, description));
        return updatedOrder;
    }

    public Auftrag deleteAuftrag(int id) {
        Auftrag deletedAuftrag = auftragManagement.deleteAuftrag(id);
        orderDeleteEvent.fire(new DeleteAuftrag(getShipIdFromUrl(deletedAuftrag.getUrl())));
        return deletedAuftrag;
    }

    private int getShipIdFromUrl(String shipUrl) {
        String[] urlParts = shipUrl.split("/");
        return Integer.parseInt(urlParts[urlParts.length - 1]);
    }

    // Events
    private void OrderAccepted(@Observes AuftragAngenommen orderAccepted) {
        auftragManagement.updateUrl(orderAccepted.getOrderId(), orderAccepted.getShipURL());
    }
}
