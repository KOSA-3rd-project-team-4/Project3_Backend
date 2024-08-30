package v0.project.mysite.work.HJH.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import v0.project.mysite.work.HJH.mapper.ViewAnnouncementsMapper;
import v0.project.mysite.work.HJH.mapper.ViewChatMapper;
import v0.project.mysite.work.HJH.model.ViewAnnouncement;
import v0.project.mysite.work.HJH.model.ViewChat;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ViewChatService {

    private final ViewChatMapper vcMapper;

    public List<ViewChat> selectById(int id) {
        return this.vcMapper.selectById(id);
    }

    public void updateUserHired(int contract_chat_id, int hire) {
        this.vcMapper.updateUserHired(contract_chat_id, hire);
    }
}
