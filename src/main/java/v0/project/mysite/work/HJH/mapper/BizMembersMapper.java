package v0.project.mysite.work.HJH.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Qualifier;
import v0.project.mysite.work.HJH.model.BizMembers;
import v0.project.mysite.work.HJH.model.Image;

@Mapper
@Qualifier("bizMembersMapper")
public interface BizMembersMapper extends BaseMapper<BizMembers, Integer>{
    // 필요시 ImageMapper에 특화된 메서드를 추가할 수 있습니다.

    @Select("SELECT * FROM BizMembers WHERE username = #{username}")
    BizMembers findByUsername(String username);

}
