package v0.project.mysite.KBC.repository;

import org.apache.ibatis.annotations.Mapper;
import v0.project.mysite.KBC.DTO.TestBiz;
import v0.project.mysite.work.HJH.model.BizMembers;
import v0.project.mysite.work.HJH.model.Members;

import java.util.List;

@Mapper
public interface IUserRepository {
    BizMembers getBizMember(String query);

}
