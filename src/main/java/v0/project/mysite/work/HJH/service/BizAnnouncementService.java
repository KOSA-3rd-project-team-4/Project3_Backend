package v0.project.mysite.work.HJH.service;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import v0.project.mysite.work.HJH.mapper.BizAnnouncementMapper;
import v0.project.mysite.work.HJH.model.BizAnnouncement;

import java.util.List;

@Service
public class BizAnnouncementService extends BaseServiceImpl<BizAnnouncement, Integer>{

    private final BizAnnouncementMapper bizAnnouncementMapper;

    public BizAnnouncementService(@Qualifier("bizAnnouncementMapper") BizAnnouncementMapper bizAnnouncementMapper) {
        this.bizAnnouncementMapper = bizAnnouncementMapper;
        assignBaseMapper(this.bizAnnouncementMapper);
    }

    public void insert(BizAnnouncement bizAnnouncement) {
        bizAnnouncementMapper.insert(bizAnnouncement);
    }

    public List<BizAnnouncement> selectUser(int id) {
        return bizAnnouncementMapper.selectUser(id);
    }

    public void deleteAnnouncement(int announcementId) {

        bizAnnouncementMapper.deleteFromTagLists(announcementId);
        bizAnnouncementMapper.deleteFromApplies(announcementId);
        bizAnnouncementMapper.deleteFromBizAnnouncements(announcementId);
    }

    public List<BizAnnouncement> selectMUser(int id) {
        return bizAnnouncementMapper.selectJobsByMemberId(id);
    }

    // 필요시 ImageService에 특화된 메서드를 추가할 수 있습니다.
}
