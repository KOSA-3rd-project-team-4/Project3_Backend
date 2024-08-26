package v0.project.mysite.work.HJH.mapper;

import java.util.List;

public interface BaseMapper<T, ID> {
    T selectById(ID id);
    List<T> selectAll();
    void insert(T entity);
    void update(T entity);
    void delete(ID id);
}
