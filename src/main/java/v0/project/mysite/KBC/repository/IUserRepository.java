package v0.project.mysite.KBC.repository;

import org.apache.ibatis.annotations.Mapper;
import v0.project.mysite.KBC.DTO.TestBiz;
import v0.project.mysite.work.HJH.model.BizMembers;

@Mapper
public interface IUserRepository {
    TestBiz getBizMember(String query);
    void insertUser(TestBiz testBiz);
}
