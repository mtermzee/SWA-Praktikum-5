package swa.auftragsmanagement.entity;

import java.util.List;

public interface AuftragManagement {
    public Auftrag getAuftragByID(int id);

    public List<Auftrag> getAuftrags();

    public Auftrag addAuftrag(String description);

    public Auftrag updateAuftrag(int id, String description);

    public Auftrag deleteAuftrag(int id);

    public Auftrag updateUrl(int id, String url);
}
