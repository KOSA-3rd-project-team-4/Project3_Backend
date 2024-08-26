package v0.project.mysite.work.HJH.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import v0.project.mysite.work.HJH.model.FilteringTags;
import v0.project.mysite.work.HJH.model.Image;
import v0.project.mysite.work.HJH.service.FilteringTagsService;
import v0.project.mysite.work.HJH.service.ImageService;

import java.util.List;

@RestController
@RequestMapping("/query/filteringtags")
public class FilteringTagsController {

    private final FilteringTagsService filteringTagsService;

    public FilteringTagsController(FilteringTagsService filteringTagsService) {
        this.filteringTagsService = filteringTagsService;
    }

    @GetMapping("/select/{id}")
    public ResponseEntity<FilteringTags> selectById(@PathVariable int id) {
        FilteringTags image = filteringTagsService.selectById(id);
        return ResponseEntity.ok(image);
    }

    @GetMapping("/select/all")
    public ResponseEntity<List<FilteringTags>> selectAll() {
        List<FilteringTags> images = filteringTagsService.selectAll();
        return ResponseEntity.ok(images);
    }

    @PostMapping("/insert")
    public ResponseEntity<FilteringTags> insert(@RequestBody FilteringTags image) {
        filteringTagsService.insert(image);
        return ResponseEntity.status(201).body(image);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Void> update(@PathVariable int id, @RequestBody FilteringTags image) {
        image.setTag_filter_id(id);
        filteringTagsService.update(image);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id) {
        filteringTagsService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
