package swa.flottenmanagement.events;


public class AuftragAngenommen {
    int orderId;
    String shipURL;

    public AuftragAngenommen(int orderId, String shipURL)
    {
        this.orderId = orderId;
        this.shipURL = shipURL;
    }

    public int getOrderId() {
        return orderId;
    }

    public String getShipURL() {
        return shipURL;
    }
}
