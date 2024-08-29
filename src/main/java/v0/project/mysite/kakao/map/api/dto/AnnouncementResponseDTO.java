package v0.project.mysite.kakao.map.api.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@Builder
public class AnnouncementResponseDTO {
    private long announcementId;
    private String title;
    private String contents;
    private double salary;
    private LocalDate dayOfWork;
    private LocalTime startWorkTime;
    private LocalTime endWorkTime;
    private Double latitude;
    private Double longitude;
}
