package swa.auftragsmanagement.events;

public class UpdateAuftrag {
    int orderId;
    String updatedDescription;

    public UpdateAuftrag(int orderId, String updatedDescription) {
        this.orderId = orderId;
        this.updatedDescription = updatedDescription;
    }

    public int getOrderId() {
        return orderId;
    }

    public String getUpdatedDescription() {
        return updatedDescription;
    }
}
