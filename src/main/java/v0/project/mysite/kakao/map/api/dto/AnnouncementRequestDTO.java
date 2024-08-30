package v0.project.mysite.kakao.map.api.dto;

import lombok.*;

@Data
@Builder
public class AnnouncementRequestDTO {
    private Double fromLatitude;
    private Double fromLongitude;
    private Double toLatitude;
    private Double toLongitude;
}
