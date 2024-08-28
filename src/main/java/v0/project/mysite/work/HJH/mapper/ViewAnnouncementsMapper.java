package v0.project.mysite.work.HJH.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Qualifier;
import v0.project.mysite.work.HJH.model.BizAnnouncement;
import v0.project.mysite.work.HJH.model.ViewAnnouncement;

import java.util.List;

@Mapper
@Qualifier("viewAnnouncementMapper")
public interface ViewAnnouncementsMapper{

    List<ViewAnnouncement> selectAll();

    ViewAnnouncement selectById(int id);

}
