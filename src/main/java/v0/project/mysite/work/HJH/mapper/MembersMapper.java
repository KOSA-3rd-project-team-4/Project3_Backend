package v0.project.mysite.work.HJH.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Qualifier;
import v0.project.mysite.work.HJH.model.Members;

import java.util.List;

@Mapper
@Qualifier("membersMapper")
public interface MembersMapper extends BaseMapper<Members, Integer> {
    // 필요시 MembersMapper에 특화된 메서드를 추가할 수 있습니다.
}
