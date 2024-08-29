package v0.project.mysite.kakao.map.api.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import v0.project.mysite.kakao.map.api.dao.KakaoMapMapper;
import v0.project.mysite.kakao.map.api.dto.AnnouncementRequestDTO;
import v0.project.mysite.kakao.map.api.dto.AnnouncementResponseDTO;
import v0.project.mysite.kakao.map.api.dto.RangeCalculateRequestDTO;

import java.util.List;

@Service
@RequiredArgsConstructor
public class KakaoMapService {
    private final KakaoMapMapper mapper;

    // 지구의 반경 (단위: km)
    private static final double EARTH_RADIUS_KM = 6371.0;

    // 반경 (단위: km)
    private static final double RADIUS_KM = 5.0;

    public List<AnnouncementResponseDTO> getAnnouncementsByRange(RangeCalculateRequestDTO rangeCalculateRequestDTO) {
        AnnouncementRequestDTO announcementRequestDTO = calculateRange(rangeCalculateRequestDTO);
        return mapper.findAnnouncementsByRange(announcementRequestDTO).stream()
                .map(e -> AnnouncementResponseDTO.builder()
                        .announcementId(e.getAnnouncement_id())
                        .title(e.getTitle())
                        .contents(e.getContents())
                        .salary(e.getSalary())
                        .dayOfWork(e.getDay_of_work().toLocalDateTime().toLocalDate())
                        .startWorkTime(e.getStart_work_time().toLocalDateTime().toLocalTime())
                        .endWorkTime(e.getEnd_work_time().toLocalDateTime().toLocalTime())
                        .latitude(e.getWork_pos_latitude())
                        .longitude(e.getWork_pos_longitude())
                        .build())
                .toList();
    }

    private AnnouncementRequestDTO calculateRange(RangeCalculateRequestDTO dto) {
        double lat = dto.getLatitude();
        double lng = dto.getLongitude();
        double latRad = Math.toRadians(lat);

        double radius = dto.getRadius();

        // 위도 변화량 계산
        double deltaLat = radius / EARTH_RADIUS_KM;
        double minLat = lat - Math.toDegrees(deltaLat);
        double maxLat = lat + Math.toDegrees(deltaLat);

        // 경도 변화량 계산
        double deltaLon = radius / (EARTH_RADIUS_KM * Math.cos(latRad));
        double minLng = lng - Math.toDegrees(deltaLon);
        double maxLng = lng + Math.toDegrees(deltaLon);

        System.out.println("origin lat = " + lat);
        System.out.println("origin lng = " + lng);

        System.out.println("minLng = " + minLng);
        System.out.println("maxLng = " + maxLng);
        System.out.println("minLat = " + minLat);
        System.out.println("maxLat = " + maxLat);

        return AnnouncementRequestDTO.builder()
                .fromLatitude(minLat)
                .fromLongitude(minLng)
                .toLatitude(maxLat)
                .toLongitude(maxLng)
                .build();
    }
}


