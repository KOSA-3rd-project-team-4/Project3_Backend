package v0.project.mysite.work.HJH.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Qualifier;
import v0.project.mysite.work.HJH.model.PR.Available_days;
import v0.project.mysite.work.HJH.model.PR.Education;
import v0.project.mysite.work.HJH.model.PR.NewMembersPR;

import java.util.List;

@Mapper
@Qualifier("PReducationMapper")
public interface PReducationMapper extends BaseMapper<Education, Integer>{
    List<Education> findById(Integer id);
}
