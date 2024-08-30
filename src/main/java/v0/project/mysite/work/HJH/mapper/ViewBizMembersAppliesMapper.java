package v0.project.mysite.work.HJH.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Qualifier;
import v0.project.mysite.work.HJH.model.ViewAnnouncement;
import v0.project.mysite.work.HJH.model.ViewBizMembersApplies;

import java.util.List;

@Mapper
@Qualifier("viewAnnouncementMapper")
public interface ViewBizMembersAppliesMapper {

    List<ViewBizMembersApplies> selectAllByBizmemberId(int id);

}
