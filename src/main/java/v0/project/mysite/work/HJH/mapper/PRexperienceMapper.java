package v0.project.mysite.work.HJH.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Qualifier;
import v0.project.mysite.work.HJH.model.PR.Available_days;
import v0.project.mysite.work.HJH.model.PR.Experience;
import v0.project.mysite.work.HJH.model.PR.NewMembersPR;

import java.util.List;

@Mapper
@Qualifier("PRecperienceMapper")
public interface PRexperienceMapper extends BaseMapper<Experience, Integer>{
    List<Experience> findById(Integer id);
}
