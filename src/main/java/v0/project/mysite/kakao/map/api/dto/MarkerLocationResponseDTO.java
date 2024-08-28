package v0.project.mysite.kakao.map.api.dto;

import lombok.*;

@Data
@Builder
public class MarkerLocationResponseDTO {
    private Long announcementId;
    private Double latitude;
    private Double longitude;
}
