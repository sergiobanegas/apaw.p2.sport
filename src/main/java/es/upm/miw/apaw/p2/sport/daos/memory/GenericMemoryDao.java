package es.upm.miw.apaw.p2.sport.daos.memory;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import es.upm.miw.apaw.p2.sport.daos.GenericDao;

public abstract class GenericMemoryDao<T> implements GenericDao<T, Integer> {

    private Map<Integer, T> map;

    protected void setMap(Map<Integer, T> map) {
        this.map = map;
    }

    @Override
    public T create(T entity) {
        map.put(map.size() + 1, entity);
        this.setId(entity, map.size());
        return entity;
    }

    @Override
    public T read(Integer id) {
        return map.get(id);
    }

    @Override
    public T update(T entity) {
        if (map.containsKey(this.getId(entity))) {
            map.put(this.getId(entity), entity);
        }
        return entity;
    }

    @Override
    public void deleteById(Integer id) {
        map.remove(id);
    }

    @Override
    public List<T> findAll() {
        return new ArrayList<T>(map.values());
    }

    protected abstract Integer getId(T entity);

    protected abstract void setId(T entity, Integer id);

}
