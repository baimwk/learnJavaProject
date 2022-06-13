package jpa;

import jpa.model.Category;
import jpa.model.Topic;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


public class AppTest {
    private EntityManager em;

    @BeforeEach
    void init() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Test");
        em = emf.createEntityManager();
        em.getTransaction().begin();
    }

    @AfterEach
    void close() {
        if (em.getTransaction().isActive()) {
            em.getTransaction().commit();
        }
        em.getEntityManagerFactory().close();
        em.close();
    }

    @Test
    void shouldPersistCategory() {
        Category cat = new Category();
        cat.setTitle("new category");
        em.persist(cat); //  Сохранить экземпляр сущности (становится managed и сохраняется в БД)
    }

    @Test
    void shouldFindCategoryById() {
        Category cat = new Category();
        cat.setTitle("test");
        em.persist(cat);
        // в логе нет селекта, тк em нашел у себя в контексте:
        Category result1 = em.find(Category.class, 1L);
        assertNotNull(result1);
        // в логе селект, тк нет в контексте em, пошел в базу:
        Category result2 = em.find(Category.class, 2L);
        assertNull(result2);

    }

    @Test
    void shouldPersistCategoryAndTopics() {
        Category cat = new Category();
        cat.setTitle("test");
        Topic topic = new Topic();
        topic.setTitle("topic");
        topic.setCategory(cat);
        em.persist(cat);
    }

    @Test
    void shouldPerformQuery() {
        Category cat = new Category();
        cat.setTitle("query");
        em.persist(cat);
        // JPQL:
        Query query = em.createQuery("SELECT c from Category c WHERE title = 'query'");
        assertNotNull(query.getSingleResult());
    }

    // Criteria API. SELECT c FROM Category c
    @Test
    void shouldFindWithCriteriaAPI() {
        Category cat = new Category();
        em.persist(cat);
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Category> query = cb.createQuery(Category.class);
        Root<Category> c = query.from(Category.class);
        query.select(c);
        List<Category> resultList = em.createQuery(query).getResultList();
        assertEquals(1, resultList.size());
    }
}
