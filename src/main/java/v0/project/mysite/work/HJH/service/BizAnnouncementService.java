package v0.project.mysite.work.HJH.service;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import v0.project.mysite.work.HJH.mapper.BizAnnouncementMapper;
import v0.project.mysite.work.HJH.mapper.ImageMapper;
import v0.project.mysite.work.HJH.model.BizAnnouncement;
import v0.project.mysite.work.HJH.model.Image;

@Service
public class BizAnnouncementService extends BaseServiceImpl<BizAnnouncement, Integer>{

    private final BizAnnouncementMapper bizAnnouncementMapper;

    public BizAnnouncementService(@Qualifier("bizAnnouncementMapper") BizAnnouncementMapper bizAnnouncementMapper) {
        this.bizAnnouncementMapper = bizAnnouncementMapper;
        assignBaseMapper(this.bizAnnouncementMapper);
    }

    // 필요시 ImageService에 특화된 메서드를 추가할 수 있습니다.
}
