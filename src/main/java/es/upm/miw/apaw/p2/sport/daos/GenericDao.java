package es.upm.miw.apaw.p2.sport.daos;

import java.util.List;

public interface GenericDao<T, ID> {

    T create(T entity);

    T read(ID id);

    T update(T entity);

    void deleteById(ID id);

    List<T> findAll();

}
