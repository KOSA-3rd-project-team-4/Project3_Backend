package v0.project.mysite.work.HJH.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import v0.project.mysite.work.HJH.model.Image;
import v0.project.mysite.work.HJH.model.Reviews;
import v0.project.mysite.work.HJH.service.ImageService;
import v0.project.mysite.work.HJH.service.ReviewsService;

import java.util.List;

@RestController
@RequestMapping("/query/reviews")
public class ReviewsController {

    private final ReviewsService reviewsService;

    public ReviewsController(ReviewsService reviewsService) {
        this.reviewsService = reviewsService;
    }

    @GetMapping("/select/{id}")
    public ResponseEntity<Reviews> selectById(@PathVariable int id) {
        Reviews reviews = reviewsService.selectById(id);
        return ResponseEntity.ok(reviews);
    }

    @GetMapping("/select/all")
    public ResponseEntity<List<Reviews>> selectAll() {
        List<Reviews> reviews = reviewsService.selectAll();
        return ResponseEntity.ok(reviews);
    }

    @PostMapping("/insert")
    public ResponseEntity<Reviews> insert(@RequestBody Reviews reviews) {
        reviewsService.insert(reviews);
        return ResponseEntity.status(201).body(reviews);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Void> update(@PathVariable int id, @RequestBody Reviews reviews) {
        reviews.setReview_id(id);
        reviewsService.update(reviews);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id) {
        reviewsService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
