package v0.project.mysite.KBC.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import v0.project.mysite.KBC.DTO.*;
import v0.project.mysite.KBC.service.MainpageService;

import java.util.List;

@Log4j2
@RequiredArgsConstructor
@RestController
public class MainpageController {

    private final MainpageService mainpageService;

    @GetMapping("/api/job-listings")
    public ResponseEntity<List<MainAnnounce>> joblist() {
        List<MainAnnounce> list = mainpageService.joblist();
        log.info(list);
        return ResponseEntity.ok(list);
    }

    @GetMapping("/api/tags")
    public ResponseEntity<List<MainAnTag>> taglist() {
        List<MainAnTag> list = mainpageService.taglist();
        log.info(list);
        return ResponseEntity.ok(list);
    }


    @GetMapping("/api/resume-list")
    public ResponseEntity<List<MainResume>> resumelist() {
        List<MainResume> list = mainpageService.resumeList();
        log.info(list);
        return ResponseEntity.ok(list);
    }
    @GetMapping("/api/resume-tags")
    public ResponseEntity<List<MainResumeTag>> resumetaglist() {
        List<MainResumeTag> list = mainpageService.resumeTagList();
        log.info(list);
        return ResponseEntity.ok(list);
    }

    @GetMapping("/api/alltag")
    public ResponseEntity<List<AllTag>> alltag() {
        List<AllTag> list = mainpageService.alltag();
        log.info(list);
        return ResponseEntity.ok(list);
    }
}
