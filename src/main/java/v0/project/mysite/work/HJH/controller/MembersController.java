package v0.project.mysite.work.HJH.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import v0.project.mysite.work.HJH.model.Image;
import v0.project.mysite.work.HJH.model.Members;
import v0.project.mysite.work.HJH.service.ImageService;
import v0.project.mysite.work.HJH.service.MembersService;

import java.util.List;

@RestController
@RequestMapping("/query/members")
public class MembersController {

    private final MembersService membersService;

    public MembersController(MembersService membersService) {
        this.membersService = membersService;
    }

    @GetMapping("/select/{id}")
    public ResponseEntity<Members> selectById(@PathVariable int id) {
        Members members = membersService.selectById(id);
        return ResponseEntity.ok(members);
    }

    @GetMapping("/select/all")
    public ResponseEntity<List<Members>> selectAll() {
        List<Members> members = membersService.selectAll();
        return ResponseEntity.ok(members);
    }

    @PostMapping("/insert")
    public ResponseEntity<Members> insert(@RequestBody Members members) {
        membersService.insert(members);
        return ResponseEntity.status(201).body(members);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Void> update(@PathVariable int id, @RequestBody Members members) {
        members.setImage_id(id);
        membersService.update(members);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id) {
        membersService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
