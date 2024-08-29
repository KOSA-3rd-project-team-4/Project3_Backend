package v0.project.mysite.kakao.map.api.dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Qualifier;
import v0.project.mysite.kakao.map.api.dto.AnnouncementRequestDTO;
import v0.project.mysite.work.HJH.model.BizAnnouncement;

import java.util.List;

@Mapper
@Qualifier("kakaoMapMapper")
public interface KakaoMapMapper {
    List<BizAnnouncement> findAnnouncementsByRange(AnnouncementRequestDTO dto);
}
