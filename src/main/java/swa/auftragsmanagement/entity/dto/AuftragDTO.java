package swa.auftragsmanagement.entity.dto;

import java.sql.Date;

import swa.auftragsmanagement.entity.Auftrag;

public class AuftragDTO {
    private int id;
    private String description;
    private Date receiptDate;
    private String url;

    public AuftragDTO() {
    }

    public AuftragDTO(Auftrag other) {
        this.id = other.getId();
        this.description = other.getDescription();
        this.receiptDate = other.getReceiptDate();
        this.url = other.getUrl();
    }

    public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public Date getReceiptDate() {
        return receiptDate;
    }

    public String getUrl() {
        return url;
    }

}
