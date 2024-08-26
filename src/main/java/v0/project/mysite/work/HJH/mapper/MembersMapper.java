package v0.project.mysite.work.HJH.mapper;

import org.apache.ibatis.annotations.Mapper;
import v0.project.mysite.work.HJH.model.Members;

import java.util.List;

@Mapper
public interface MembersMapper {

    Members selectById(int id);

    List<Members> selectAll();

    void insert(Members members);

    void update(Members members);

    void delete(int id);
}
