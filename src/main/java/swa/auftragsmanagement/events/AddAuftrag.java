package swa.auftragsmanagement.events;

public class AddAuftrag {
    int orderId;

    public AddAuftrag(int id) {
        orderId = id;
    }

    public int getOrderId() {
        return orderId;
    }
}
