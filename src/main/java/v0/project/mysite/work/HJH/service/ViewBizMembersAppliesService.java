package v0.project.mysite.work.HJH.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import v0.project.mysite.work.HJH.mapper.ViewAnnouncementsMapper;
import v0.project.mysite.work.HJH.mapper.ViewBizMembersAppliesMapper;
import v0.project.mysite.work.HJH.model.ViewAnnouncement;
import v0.project.mysite.work.HJH.model.ViewBizMembersApplies;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ViewBizMembersAppliesService {

    private final ViewBizMembersAppliesMapper vbmaMapper;

    public List<ViewBizMembersApplies> selectById(int id) {
        return this.vbmaMapper.selectAllByBizmemberId(id);
    }
}
