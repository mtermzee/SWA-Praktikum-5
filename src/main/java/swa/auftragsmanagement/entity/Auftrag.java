package swa.auftragsmanagement.entity;

public class Auftrag {
    private int id;
    private String description;
    private String receiptDate;
    private String url;

    public Auftrag() {

    }

    public Auftrag(int id, String description, String receiptDate, String url) {
        this.id = id;
        this.description = description;
        this.receiptDate = receiptDate;
        this.url = url;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getReceiptDate() {
        return receiptDate;
    }

    public void setReceiptDate(String receiptDate) {
        this.receiptDate = receiptDate;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

}
