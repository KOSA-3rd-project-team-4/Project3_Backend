package v0.project.mysite.work.HJH.service;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import v0.project.mysite.work.HJH.mapper.AppliesMapper;
import v0.project.mysite.work.HJH.mapper.ImageMapper;
import v0.project.mysite.work.HJH.model.Applies;
import v0.project.mysite.work.HJH.model.Image;
import v0.project.mysite.work.HJH.model.ViewAnnouncement;

import java.util.List;

@Service
public class AppliesService extends BaseServiceImpl<Applies, Integer>{

    private final AppliesMapper appliesMapper;

    public AppliesService(@Qualifier("appliesMapper") AppliesMapper appliesMapper) {
        this.appliesMapper = appliesMapper;
        assignBaseMapper(this.appliesMapper);
    }

    // 필요시 ImageService에 특화된 메서드를 추가할 수 있습니다.
    public void updateChatCreated(int chat_created, int apply_id) {
        appliesMapper.updateChatCreated(chat_created, apply_id);
    }

    public void updateUserHired(int user_hired, int apply_id) {
        appliesMapper.updateUserHired(user_hired, apply_id);
    }
}
