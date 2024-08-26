package v0.project.mysite.work.HJH.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import v0.project.mysite.work.HJH.model.Members;
import v0.project.mysite.work.HJH.model.MembersPR;
import v0.project.mysite.work.HJH.service.MembersPRService;
import v0.project.mysite.work.HJH.service.MembersService;

import java.util.List;

@RestController
@RequestMapping("/query/memberspr")
public class MembersPRController {

    private final MembersPRService membersPRService;

    public MembersPRController(MembersPRService membersPRService) {
        this.membersPRService = membersPRService;
    }

    @GetMapping("/select/{id}")
    public ResponseEntity<MembersPR> selectById(@PathVariable int id) {
        MembersPR membersPR = membersPRService.selectById(id);
        return ResponseEntity.ok(membersPR);
    }

    @GetMapping("/select/all")
    public ResponseEntity<List<MembersPR>> selectAll() {
        List<MembersPR> membersPR = membersPRService.selectAll();
        return ResponseEntity.ok(membersPR);
    }

    @PostMapping("/insert")
    public ResponseEntity<MembersPR> insert(@RequestBody MembersPR membersPR) {
        membersPRService.insert(membersPR);
        return ResponseEntity.status(201).body(membersPR);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Void> update(@PathVariable int id, @RequestBody MembersPR membersPR) {
        membersPR.setPr_id(id);
        membersPRService.update(membersPR);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id) {
        membersPRService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
