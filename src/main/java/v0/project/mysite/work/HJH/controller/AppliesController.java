package v0.project.mysite.work.HJH.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import v0.project.mysite.work.HJH.model.Applies;
import v0.project.mysite.work.HJH.model.Image;
import v0.project.mysite.work.HJH.service.AppliesService;
import v0.project.mysite.work.HJH.service.ImageService;

import java.util.List;

@RestController
@RequestMapping("/query/applies")
public class AppliesController {

    private final AppliesService appliesService;

    public AppliesController(AppliesService appliesService) {
        this.appliesService = appliesService;
    }

    @GetMapping("/select/{id}")
    public ResponseEntity<Applies> selectById(@PathVariable int id) {
        Applies image = appliesService.selectById(id);
        return ResponseEntity.ok(image);
    }

    @GetMapping("/select/all")
    public ResponseEntity<List<Applies>> selectAll() {
        List<Applies> images = appliesService.selectAll();
        return ResponseEntity.ok(images);
    }

    @PostMapping("/insert")
    public ResponseEntity<Applies> insert(@RequestBody Applies image) {
        appliesService.insert(image);
        return ResponseEntity.status(200).body(image);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Void> update(@PathVariable int id, @RequestBody Applies image) {
        image.setApply_id(id);
        appliesService.update(image);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id) {
        appliesService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/update/chat/{chat_created}/{id}")
    public ResponseEntity<Void> updateChat(@PathVariable int chat_created, @PathVariable int id) {
        appliesService.updateChatCreated(chat_created, id);
//        System.out.println(chat_created + " " + id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/update/hired/{user_hired}/{id}")
    public ResponseEntity<Void> updateHired(@PathVariable int user_hired, @PathVariable int id) {
        appliesService.updateUserHired(user_hired, id);
        return ResponseEntity.noContent().build();
    }
}
