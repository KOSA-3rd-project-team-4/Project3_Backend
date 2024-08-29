package v0.project.mysite.work.HJH.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import v0.project.mysite.work.HJH.mapper.BizMembersMapper;
import v0.project.mysite.work.HJH.model.BizMembers;
import v0.project.mysite.work.HJH.model.Image;
import v0.project.mysite.work.HJH.service.BizMembersService;
import v0.project.mysite.work.HJH.service.ImageService;

import java.util.List;

@RestController
@RequestMapping("/query/bizmembers")
public class BizMembersController {

    private final BizMembersMapper bizMembersMapper;
    private final BizMembersService bizMembersService;

    public BizMembersController(BizMembersMapper bizMembersMapper, BizMembersService bizMembersService) {
        this.bizMembersMapper = bizMembersMapper;
        this.bizMembersService = bizMembersService;
    }

    @GetMapping("/select/{id}")
    public ResponseEntity<BizMembers> selectById(@PathVariable int id) {
        BizMembers image = bizMembersMapper.selectById(id);
        return ResponseEntity.ok(image);
    }

    @GetMapping("/select/all")
    public ResponseEntity<List<BizMembers>> selectAll() {
        List<BizMembers> images = bizMembersMapper.selectAll();
        return ResponseEntity.ok(images);
    }

    @PostMapping("/insert")
    public ResponseEntity<BizMembers> insert(@RequestBody BizMembers image) {
        bizMembersMapper.insert(image);
        return ResponseEntity.status(201).body(image);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Void> update(@PathVariable int id, @RequestBody BizMembers image) {
        image.setBizmember_id(id);
        bizMembersService.update(image);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id) {
        bizMembersMapper.delete(id);
        return ResponseEntity.noContent().build();
    }
}
