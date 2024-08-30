package v0.project.mysite.work.HJH.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import v0.project.mysite.work.HJH.mapper.ImageMapper;
import v0.project.mysite.work.HJH.mapper.ViewAnnouncementsMapper;
import v0.project.mysite.work.HJH.model.Image;
import v0.project.mysite.work.HJH.model.ViewAnnouncement;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ViewAnnouncementsService{

    private final ViewAnnouncementsMapper vaMapper;

    public List<ViewAnnouncement> selectAll() {
        return this.vaMapper.selectAll();
    }

    public ViewAnnouncement selectById(int id) {
        return this.vaMapper.selectById(id);
    }
}
