package br.com.db1;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;

public abstract class AbstractTestCase {
    protected static EntityManagerFactory emf;

    protected EntityManager manager;

    @BeforeClass
    public static void createEntityManagerFactory() {
        emf = Persistence.createEntityManagerFactory("db1start");
    }

    @AfterClass
    public static void closeEntityManagerFactory() {
        emf.close();
    }

    @Before
    public void beginTransaction() {
        manager = emf.createEntityManager();
        manager.getTransaction().begin();
    }

    @After
    public void rollbackTransaction() {   
        if (manager.getTransaction().isActive()) {
            manager.getTransaction().rollback();
        }

        if (manager.isOpen()) {
            manager.close();
        }
    }
}