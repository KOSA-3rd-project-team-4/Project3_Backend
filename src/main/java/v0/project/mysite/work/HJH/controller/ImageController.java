package v0.project.mysite.work.HJH.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import v0.project.mysite.work.HJH.model.Image;
import v0.project.mysite.work.HJH.service.ImageService;

import java.util.List;

@RestController
@RequestMapping("/query/images")
public class ImageController {

    private final ImageService imageService;

    public ImageController(ImageService imageService) {
        this.imageService = imageService;
    }

    @GetMapping("/select/{id}")
    public ResponseEntity<Image> selectById(@PathVariable int id) {
        Image image = imageService.selectById(id);
        return ResponseEntity.ok(image);
    }

    @GetMapping("/select/all")
    public ResponseEntity<List<Image>> selectAll() {
        List<Image> images = imageService.selectAll();
        return ResponseEntity.ok(images);
    }

    @PostMapping("/insert")
    public ResponseEntity<Image> insert(@RequestBody Image image) {
        imageService.insert(image);
        return ResponseEntity.status(201).body(image);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Void> update(@PathVariable int id, @RequestBody Image image) {
        image.setImage_id(id);
        imageService.update(image);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id) {
        imageService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
