package hva.jabbarn.repository;

import hva.jabbarn.util.Identifiable;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
public abstract class AbstractEntityRepositoryJPA<E extends Identifiable> implements EntityRepository<E> {

    @PersistenceContext
    protected EntityManager entityManager;

    private Class<E> theEntityClass;

    public AbstractEntityRepositoryJPA(Class<E> entityClass) {
        this.theEntityClass = entityClass;
        System.out.println("Created:" + this.getClass().getName() + "<" + this.theEntityClass.getSimpleName() + ">");
    }

    @Override
    public List<E> findAll() {
        TypedQuery<E> query = this.entityManager.createQuery("select e from " + this.theEntityClass.getSimpleName() + " e", theEntityClass);
        return query.getResultList();
    }

    @Override
    public E findById(long id) {
        if (entityManager.find(theEntityClass, id) == null) {
            try {
                throw new Exception();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return entityManager.find(theEntityClass, id);
    }

    @Override
    public E save(E entity) {
        return entityManager.merge(entity);
    }

    @Override
    public boolean deleteById(long id) {
        E toDelete = this.findById(id);

        if (toDelete != null) {
            this.entityManager.remove(toDelete);
            return true;
        }

        return false;
    }

    @Override
    public List<E> findByQuery(String jpqlName, Object... params) {
        return this.entityManager.createNamedQuery(jpqlName, this.theEntityClass).setParameter(1, params[0]).getResultList();
    }
}
