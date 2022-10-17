package hva.jabbarn.repository;

import hva.jabbarn.util.Identifiable;

import java.util.List;

public interface EntityRepository<E extends Identifiable> {

    List<E> findByQuery(String jpqlName, Object... params);

    public List<E> findAll();

    public E findById(long id);

    public E save(E entity);

    public boolean deleteById(long id);
}
