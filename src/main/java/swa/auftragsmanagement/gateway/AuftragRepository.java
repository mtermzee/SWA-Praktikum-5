package swa.auftragsmanagement.gateway;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import swa.auftragsmanagement.entity.Auftrag;
import swa.auftragsmanagement.entity.AuftragManagement;

@ApplicationScoped
public class AuftragRepository implements AuftragManagement {
    @Inject
    EntityManager em;

    @Override
    @Transactional
    public Auftrag getAuftragByID(int id) {
        return em.find(Auftrag.class, id);
    }

    @Override
    @Transactional
    public List<Auftrag> getAuftrags() {
        return em.createQuery("SELECT a FROM Auftrag a", Auftrag.class).getResultList();
    }

    @Override
    @Transactional
    public Auftrag addAuftrag(String description) {
        if (description != "") {
            Auftrag order = new Auftrag(description, null);
            em.persist(order);
            return order;
        }
        return null;
    }

    @Override
    @Transactional
    public Auftrag updateAuftrag(int id, String description) {
        Auftrag order = em.find(Auftrag.class, id);
        if (order != null) {
            order.setDescription(description);
            em.merge(order);
            return order;
        }
        return null;
    }

    @Override
    @Transactional
    public Auftrag deleteAuftrag(int id) {
        Auftrag order = em.find(Auftrag.class, id);
        if (order != null) {
            em.remove(order);
            return order;
        }
        return null;
    }

    @Override
    @Transactional
    public Auftrag updateUrl(int id, String url) {
        Auftrag order = em.find(Auftrag.class, id);
        if (order != null) {
            order.setUrl(url);
            em.merge(order);
            return order;
        }
        return null;
    }

    @Override
    public List<Auftrag> getOrdersWithoutShip() {
        return em.createQuery("SELECT a FROM Auftrag a WHERE a.url IS NULL", Auftrag.class).getResultList();
    }

}
