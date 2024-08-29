package v0.project.mysite.work.HJH.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Qualifier;
import v0.project.mysite.work.HJH.model.BizAnnouncement;
import v0.project.mysite.work.HJH.model.Image;
import v0.project.mysite.work.HJH.model.PR.NewMembersPR;

import java.util.List;

@Mapper
@Qualifier("bizAnnouncementMapper")
public interface BizAnnouncementMapper extends BaseMapper<BizAnnouncement, Integer>{
    // 필요시 ImageMapper에 특화된 메서드를 추가할 수 있습니다.
    List<BizAnnouncement> selectUser(Integer id);


}
