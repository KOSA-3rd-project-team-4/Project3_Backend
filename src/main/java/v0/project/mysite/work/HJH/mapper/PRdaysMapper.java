package v0.project.mysite.work.HJH.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Qualifier;
import v0.project.mysite.work.HJH.model.PR.Available_days;

import java.util.List;

@Mapper
@Qualifier("PRdaysMapper")
public interface PRdaysMapper extends BaseMapper<Available_days, Integer>{
    List<Available_days> findById(Integer id);
}
