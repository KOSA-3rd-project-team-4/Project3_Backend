package v0.project.mysite.work.HJH.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import v0.project.mysite.work.HJH.model.Image;
import v0.project.mysite.work.HJH.service.ImageService;

import java.util.List;

@RestController
@RequestMapping("/query/images")
@RequiredArgsConstructor
public class ImageController {

    private final ImageService imageService;

    @GetMapping("/select/{id}")
    public Image getImageById(@PathVariable int id) {
        return imageService.selectById(id);
    }

    @GetMapping("/select/all")
    public List<Image> selectAll() {
        return imageService.selectAll();
    }

    @PostMapping("/insert")
    public void createImage(@RequestBody Image image) {
        imageService.insert(image);
    }

    @PutMapping("/update/{id}")
    public void updateImage(@PathVariable int id, @RequestBody Image image) {
        image.setImage_id(id);
        imageService.update(image);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteImage(@PathVariable int id) {
        imageService.delete(id);
    }
}
