package v0.project.mysite.kakao.map.api.dto;

import lombok.*;

@Data
@Builder
public class RangeCalculateRequestDTO {
    private Double latitude;
    private Double longitude;
    private Double radius;
}
