package v0.project.mysite.kakao.map.api.controller;

import groovy.util.logging.Log4j2;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import v0.project.mysite.kakao.map.api.dto.AnnouncementResponseDTO;
import v0.project.mysite.kakao.map.api.dto.RangeCalculateRequestDTO;
import v0.project.mysite.kakao.map.api.service.KakaoMapService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Log4j2
@RestController
@RequiredArgsConstructor
public class KakaoMapController {
    private final KakaoMapService kakaoMapService;

    @GetMapping("/location")
    public ResponseEntity<Map<String, Object>> getLocations(RangeCalculateRequestDTO dto) {
        Map<String, Object> resultMap = new HashMap<>();
        List<AnnouncementResponseDTO> markerInfoList = kakaoMapService.getAnnouncementsByRange(dto);
        if (markerInfoList.isEmpty()) {
            resultMap.put("success", false);
            return ResponseEntity.status(204).body(resultMap);
        }
        resultMap.put("success", true);
        resultMap.put("markerInfoList", markerInfoList);

        return ResponseEntity.ok(resultMap);
    }
}
