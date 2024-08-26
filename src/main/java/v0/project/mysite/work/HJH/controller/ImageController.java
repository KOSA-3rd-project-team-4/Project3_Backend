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
        return imageService.selectImageById(id);
    }

    @GetMapping("/select/all")
    public List<Image> selectAll() {
        return imageService.selectAllImage();
    }

    @PostMapping("/insert")
    public void createImage(@RequestBody Image image) {
        imageService.insertImage(image);
    }

    @PutMapping("/update/{id}")
    public void updateImage(@PathVariable int id, @RequestBody Image image) {
        image.setImage_id(id);
        imageService.updateImage(image);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteImage(@PathVariable int id) {
        imageService.deleteImage(id);
    }
}
