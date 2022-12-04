package swa.auftragsmanagement.events;

public class DeleteAuftrag {
    int shipId;

    public DeleteAuftrag(int shipId) {
        this.shipId = shipId;
    }

    public int getShipId() {
        return shipId;
    }
}
