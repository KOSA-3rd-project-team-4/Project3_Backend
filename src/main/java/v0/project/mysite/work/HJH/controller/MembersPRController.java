package v0.project.mysite.work.HJH.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import v0.project.mysite.work.HJH.controller.dto.MPR;
import v0.project.mysite.work.HJH.model.Members;
import v0.project.mysite.work.HJH.model.MembersPR;
import v0.project.mysite.work.HJH.model.PR.NewMembersPR;
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
    public ResponseEntity<MPR> selectById(@PathVariable int id) {
        MPR membersPR = membersPRService.selectById(id);
        return ResponseEntity.ok(membersPR);
    }

    @GetMapping("/select/all")
    public ResponseEntity<List<NewMembersPR>> selectAll() {
        List<NewMembersPR> membersPR = membersPRService.selectAll();
        return ResponseEntity.ok(membersPR);
    }

    @PostMapping("/insert")
    public ResponseEntity<String> insert(@RequestBody MPR membersPR) {
        int user_id = 1;
        System.out.println("확인용");
        membersPRService.insert(membersPR, user_id);
        return ResponseEntity.ok("Resume saved successfully");
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> update(@PathVariable int id, @RequestBody MPR membersPR) {
        int user_id = 1;
        membersPR.setId(id);
        membersPRService.update(membersPR, user_id);
        return ResponseEntity.ok("Resume saved successfully");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id) {
        membersPRService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/select/user")
    public ResponseEntity<List<NewMembersPR>> selectUser() {
        List<NewMembersPR> membersPR = membersPRService.selectUser();
        return ResponseEntity.ok(membersPR);
    }
}
