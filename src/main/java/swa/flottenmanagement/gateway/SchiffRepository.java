package swa.flottenmanagement.gateway;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import swa.flottenmanagement.entity.Schiff;
import swa.flottenmanagement.entity.SchiffManagement;

@ApplicationScoped
public class SchiffRepository implements SchiffManagement {
    @Inject
    EntityManager em;

    @Override
    @Transactional
    public Schiff getSchiff(int id) {
        return em.find(Schiff.class, id);
    }

    @Override
    @Transactional
    public List<Schiff> getSchiffs() {
        return em.createQuery("SELECT s FROM Schiff s", Schiff.class).getResultList();
    }

    @Override
    @Transactional
    public Schiff addSchiff(String name) {
        if (name != "") {
            Schiff ship = new Schiff(name, true);
            em.persist(ship);
            return ship;
        }
        return null;
    }

    @Override
    @Transactional
    public Schiff removeSchiff(int id) {
        Schiff ship = em.find(Schiff.class, id);
        if (ship != null) {
            em.remove(ship);
            return ship;
        }
        return null;
    }

    @Override
    @Transactional
    public Schiff updateSchiff(int id, String name) {
        Schiff ship = em.find(Schiff.class, id);
        if (ship != null) {
            ship.setName(name);
            em.merge(ship);
            return ship;
        }
        return null;
    }

    @Override
    @Transactional
    public List<Schiff> findAvailableSchiffs() {
        return em.createQuery("SELECT s FROM Schiff s WHERE s.isFree = true", Schiff.class).getResultList();
    }

    @Override
    @Transactional
    public void setShipAvailability(int shipId, boolean isAvailable) {
        Schiff ship = em.find(Schiff.class, shipId);
        if (ship != null) {
            ship.setFree(isAvailable);
            em.merge(ship);
        }
    }

}
