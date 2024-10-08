package v0.project.mysite.work.HJH.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import v0.project.mysite.work.HJH.model.BizAnnouncement;
import v0.project.mysite.work.HJH.model.Image;
import v0.project.mysite.work.HJH.service.BizAnnouncementService;
import v0.project.mysite.work.HJH.service.ImageService;

import java.util.List;

@RestController
@RequestMapping("/query/bizannouncement")
public class BizAnnouncementController {

    private final BizAnnouncementService bizAnnouncementService;

    public BizAnnouncementController(BizAnnouncementService bizAnnouncementService) {
        this.bizAnnouncementService = bizAnnouncementService;
    }

    @GetMapping("/select/{id}")
    public ResponseEntity<BizAnnouncement> selectById(@PathVariable int id) {
        BizAnnouncement image = bizAnnouncementService.selectById(id);
        return ResponseEntity.ok(image);
    }

    @GetMapping("/select/all")
    public ResponseEntity<List<BizAnnouncement>> selectAll() {
        List<BizAnnouncement> images = bizAnnouncementService.selectAll();
        return ResponseEntity.ok(images);
    }

    @PostMapping("/insert")
    public ResponseEntity<BizAnnouncement> insert(@RequestBody BizAnnouncement image) {
        bizAnnouncementService.insert(image);
        return ResponseEntity.status(201).body(image);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Void> update(@PathVariable int id, @RequestBody BizAnnouncement image) {
        image.setAnnouncement_id(id);
        bizAnnouncementService.update(image);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id) {
        bizAnnouncementService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
