package swa.flottenmanagement.control;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import swa.flottenmanagement.entity.Schiff;
import swa.flottenmanagement.entity.SchiffManagement;

@ApplicationScoped
public class SchiffService {
    @Inject
    SchiffManagement schiffManagement;

    public Schiff getSchiff(int id) {
        return schiffManagement.getSchiff(id);
    }

    public List<Schiff> getSchiffs() {
        return schiffManagement.getSchiffs();
    }

    public Schiff addSchiff(String name) {
        return schiffManagement.addSchiff(name);
    }

    public Schiff removeSchiff(int id) {
        return schiffManagement.removeSchiff(id);
    }

    public Schiff updateSchiff(int id, String name) {
        return schiffManagement.updateSchiff(id, name);
    }
}
