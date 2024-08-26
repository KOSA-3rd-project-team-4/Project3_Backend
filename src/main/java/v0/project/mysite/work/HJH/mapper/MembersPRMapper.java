package v0.project.mysite.work.HJH.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Qualifier;
import v0.project.mysite.work.HJH.model.Image;
import v0.project.mysite.work.HJH.model.MembersPR;

@Mapper
@Qualifier("membersPRMapper")
public interface MembersPRMapper extends BaseMapper<MembersPR, Integer>{
    // 필요시 ImageMapper에 특화된 메서드를 추가할 수 있습니다.
}
