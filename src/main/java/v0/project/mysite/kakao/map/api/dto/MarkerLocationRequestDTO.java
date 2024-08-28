package v0.project.mysite.kakao.map.api.dto;

import lombok.*;

@Data
@Builder
public class MarkerLocationRequestDTO {
    private Double fromLatitude;
    private Double fromLongitude;
    private Double toLatitude;
    private Double toLongitude;
}
