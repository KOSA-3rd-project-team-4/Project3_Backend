package v0.project.mysite.work.HJH.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Qualifier;
import v0.project.mysite.work.HJH.model.Applies;
import v0.project.mysite.work.HJH.model.Image;

@Mapper
@Qualifier("appliesMapper")
public interface AppliesMapper extends BaseMapper<Applies, Integer>{
    // 필요시 ImageMapper에 특화된 메서드를 추가할 수 있습니다.
    void updateChatCreated(int chat_created, int apply_id);

    void updateUserHired(int user_hired, int apply_id);
}
