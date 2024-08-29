package v0.project.mysite.work.HJH.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Qualifier;
import v0.project.mysite.work.HJH.model.Image;
import v0.project.mysite.work.HJH.model.MembersPR;
import v0.project.mysite.work.HJH.model.PR.Available_days;
import v0.project.mysite.work.HJH.model.PR.NewMembersPR;

import java.util.List;

@Mapper
@Qualifier("membersPRMapper")
public interface MembersPRMapper extends BaseMapper<NewMembersPR, Integer>{
    // 필요시 ImageMapper에 특화된 메서드를 추가할 수 있습니다.

    // TODO 0828 MyBatis에 선언한 메서드명으로 메서드 선언
    List<NewMembersPR> selectUser(Integer id);
}
