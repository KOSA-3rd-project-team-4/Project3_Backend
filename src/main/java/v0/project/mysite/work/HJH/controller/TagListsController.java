package v0.project.mysite.work.HJH.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import v0.project.mysite.work.HJH.model.Image;
import v0.project.mysite.work.HJH.model.TagLists;
import v0.project.mysite.work.HJH.service.ImageService;
import v0.project.mysite.work.HJH.service.TagListsService;

import java.util.List;

@RestController
@RequestMapping("/query/taglists")
public class TagListsController {

    private final TagListsService tagListsService;

    public TagListsController(TagListsService tagListsService) {
        this.tagListsService = tagListsService;
    }

    @GetMapping("/select/{id}")
    public ResponseEntity<TagLists> selectById(@PathVariable int id) {
        TagLists image = tagListsService.selectById(id);
        return ResponseEntity.ok(image);
    }

    @GetMapping("/select/all")
    public ResponseEntity<List<TagLists>> selectAll() {
        List<TagLists> images = tagListsService.selectAll();
        return ResponseEntity.ok(images);
    }

    @PostMapping("/insert")
    public ResponseEntity<TagLists> insert(@RequestBody TagLists image) {
        tagListsService.insert(image);
        return ResponseEntity.status(201).body(image);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Void> update(@PathVariable int id, @RequestBody TagLists image) {
        image.setTag_id(id);
        tagListsService.update(image);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id) {
        tagListsService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
