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
        System.out.println(image.getBizmember_id());
        int user_id = 1;
        image.setBizmember_id(user_id);
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
        bizAnnouncementService.deleteAnnouncement(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/select/user/{id}")
    public ResponseEntity<List<BizAnnouncement>> selectUser(@PathVariable int id) {
        List<BizAnnouncement> images = bizAnnouncementService.selectUser(id);
        return ResponseEntity.ok(images);
    }

    @GetMapping("/select/muser/{id}")
    public ResponseEntity<List<BizAnnouncement>> selectMUser(@PathVariable int id) {
        List<BizAnnouncement> images = bizAnnouncementService.selectMUser(id);
        return ResponseEntity.ok(images);
    }
}
