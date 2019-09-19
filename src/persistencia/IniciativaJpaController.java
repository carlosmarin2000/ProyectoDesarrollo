/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import modelo.Iniciativa;
import persistencia.exceptions.NonexistentEntityException;
import persistencia.exceptions.PreexistingEntityException;

/**
 *
 * @author Lenovo
 */
public class IniciativaJpaController implements Serializable {

    public IniciativaJpaController() {
        this.emf = Persistence.createEntityManagerFactory("DesarrolloSofPU");
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Iniciativa iniciativa) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(iniciativa);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findIniciativa(iniciativa.getCodIniciativa()) != null) {
                throw new PreexistingEntityException("Iniciativa " + iniciativa + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Iniciativa iniciativa) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            iniciativa = em.merge(iniciativa);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = iniciativa.getCodIniciativa();
                if (findIniciativa(id) == null) {
                    throw new NonexistentEntityException("The iniciativa with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Integer id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Iniciativa iniciativa;
            try {
                iniciativa = em.getReference(Iniciativa.class, id);
                iniciativa.getCodIniciativa();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The iniciativa with id " + id + " no longer exists.", enfe);
            }
            em.remove(iniciativa);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Iniciativa> findIniciativaEntities() {
        return findIniciativaEntities(true, -1, -1);
    }

    public List<Iniciativa> findIniciativaEntities(int maxResults, int firstResult) {
        return findIniciativaEntities(false, maxResults, firstResult);
    }

    private List<Iniciativa> findIniciativaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Iniciativa.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public Iniciativa findIniciativa(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Iniciativa.class, id);
        } finally {
            em.close();
        }
    }

    public int getIniciativaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Iniciativa> rt = cq.from(Iniciativa.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
