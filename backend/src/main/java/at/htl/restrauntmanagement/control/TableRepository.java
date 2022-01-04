package at.htl.restrauntmanagement.control;

import at.htl.restrauntmanagement.entity.Customer;
import at.htl.restrauntmanagement.entity.Table;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.List;

@ApplicationScoped
public class TableRepository {

    @Inject
    EntityManager em;

    @Transactional
    public Table saveTable(Table table) {
        return em.merge(table);
    }

    public List<Table> getAllTables() {
        TypedQuery<Table> query = em
                .createQuery("select t from Table t", Table.class);

        return query.getResultList();
    }
    public void validateTable(@Valid Table table) {

    }

    public Table findById(Long id) {
        TypedQuery<Table> query = em
                .createQuery("select t from Table t where :ID = t.id", Table.class);
        query.setParameter("ID", id);

        return query.getSingleResult();
    }
}
