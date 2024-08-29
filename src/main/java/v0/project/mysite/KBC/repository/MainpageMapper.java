package v0.project.mysite.KBC.repository;

import org.apache.ibatis.annotations.Mapper;
import v0.project.mysite.KBC.DTO.*;

import java.util.List;

@Mapper
public interface MainpageMapper {
    List<MainAnnounce> joblist();
    List<MainAnTag> taglist();
    List<MainResume> resumeList();
    List<MainResumeTag> resumeTagList();
    List<AllTag> alltag();
}
