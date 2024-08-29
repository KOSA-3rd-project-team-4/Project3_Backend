package v0.project.mysite.work.HJH.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Qualifier;
import v0.project.mysite.work.HJH.model.PR.Tags;

import java.util.List;

@Mapper
@Qualifier("PRtagsMapper")
public interface PRtagsMapper extends BaseMapper<Tags, Integer>{
    List<Tags> findById(Integer id);
}
