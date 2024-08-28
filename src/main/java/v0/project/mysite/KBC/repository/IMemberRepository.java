package v0.project.mysite.KBC.repository;

import org.apache.ibatis.annotations.Mapper;
import v0.project.mysite.work.HJH.model.Members;

import java.util.List;

@Mapper
public interface IMemberRepository {
    List<Members> selectAll();
}
