package v0.project.mysite.work.HJH.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import v0.project.mysite.work.HJH.model.Image;
import v0.project.mysite.work.HJH.model.Members;
import v0.project.mysite.work.HJH.service.ImageService;
import v0.project.mysite.work.HJH.service.MembersService;

import java.util.List;

@RestController
@RequestMapping("/query/members")
@RequiredArgsConstructor
public class MembersController {

    private final MembersService membersService;

    @GetMapping("/select/{id}")
    public Members selectById(@PathVariable int id) {
        return membersService.selectById(id);
    }

    @GetMapping("/select/all")
    public List<Members> selectAll() {
        return membersService.selectAll();
    }

    @PostMapping("/insert")
    public void insert(@RequestBody Members members) {
        membersService.insert(members);
    }

    @PutMapping("/update/{id}")
    public void update(@PathVariable int id, @RequestBody Members members) {
        members.setMember_id(id);
        membersService.update(members);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable int id) {
        membersService.delete(id);
    }
}
