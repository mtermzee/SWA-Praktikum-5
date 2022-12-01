package swa.auftragsmanagement.control;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import swa.auftragsmanagement.entity.Auftrag;
import swa.auftragsmanagement.entity.AuftragManagement;

@ApplicationScoped
public class AuftragService {
    @Inject
    AuftragManagement auftragManagement;

    public Auftrag getAuftragByID(int id) {
        return auftragManagement.getAuftragByID(id);
    }

    public List<Auftrag> getAuftrags() {
        return auftragManagement.getAuftrags();
    }

    public Auftrag addAuftrag(String description) {
        return auftragManagement.addAuftrag(description);
    }

    public Auftrag updateAuftrag(int id, String description) {
        return auftragManagement.updateAuftrag(id, description);
    }

    public Auftrag deleteAuftrag(int id) {
        return auftragManagement.deleteAuftrag(id);
    }
}
