package ec.edu.ups.dao;
//qweqwe
import java.util.List;

public interface GenericcDAO<T, ID> {

    public void create(T entity);

    public T read(ID id);

    public void update(T entity);

    public void delete(T entity);

    public void deleteByID(ID id);
    
    public List<T> findAll();
}
