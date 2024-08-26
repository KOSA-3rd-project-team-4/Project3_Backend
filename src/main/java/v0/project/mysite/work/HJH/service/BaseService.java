package v0.project.mysite.work.HJH.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import v0.project.mysite.work.HJH.mapper.BaseMapper;

import java.util.List;

public interface BaseService<T, ID> {
    T selectById(ID id);
    List<T> selectAll();
    void insert(T entity);
    void update(T entity);
    void delete(ID id);
}
