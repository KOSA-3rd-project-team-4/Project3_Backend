package v0.project.mysite.work.HJH.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import v0.project.mysite.work.HJH.mapper.BaseMapper;

import java.util.List;

@Service
@Transactional
public class BaseServiceImpl<T, ID> implements BaseService<T, ID> {

    private final BaseMapper<T, ID> baseMapper;

    @Autowired
    public BaseServiceImpl(BaseMapper<T, ID> baseMapper) {
        this.baseMapper = baseMapper;
    }

    @Override
    public T selectById(ID id) {
        return baseMapper.selectById(id);
    }

    @Override
    public List<T> selectAll() {
        return baseMapper.selectAll();
    }

    @Override
    public void insert(T entity) {
        baseMapper.insert(entity);
    }

    @Override
    public void update(T entity) {
        baseMapper.update(entity);
    }

    @Override
    public void delete(ID id) {
        baseMapper.delete(id);
    }
}
