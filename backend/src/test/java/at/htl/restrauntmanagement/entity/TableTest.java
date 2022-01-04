package at.htl.restrauntmanagement.entity;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@QuarkusTest
class TableTest {

    @Inject
    EntityManager em;

    @Test
    @Transactional
    void addTable(){
        em.persist(new Table("1L",4));
    }
}