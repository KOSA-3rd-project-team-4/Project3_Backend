package v0.project.mysite.work.HJH.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import v0.project.mysite.work.HJH.model.ContractChatrooms;
import v0.project.mysite.work.HJH.model.Image;
import v0.project.mysite.work.HJH.service.ContractChatroomsService;
import v0.project.mysite.work.HJH.service.ImageService;

import java.util.List;

@RestController
@RequestMapping("/query/contractchatrooms")
public class ContractChatroomsController {

    private final ContractChatroomsService contractChatroomsService;

    public ContractChatroomsController(ContractChatroomsService contractChatroomsService) {
        this.contractChatroomsService = contractChatroomsService;
    }

    @GetMapping("/select/{id}")
    public ResponseEntity<ContractChatrooms> selectById(@PathVariable int id) {
        ContractChatrooms image = contractChatroomsService.selectById(id);
        return ResponseEntity.ok(image);
    }

    @GetMapping("/select/all")
    public ResponseEntity<List<ContractChatrooms>> selectAll() {
        List<ContractChatrooms> images = contractChatroomsService.selectAll();
        return ResponseEntity.ok(images);
    }

    @PostMapping("/insert")
    public ResponseEntity<ContractChatrooms> insert(@RequestBody ContractChatrooms image) {
        contractChatroomsService.insert(image);
        return ResponseEntity.status(201).body(image);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Void> update(@PathVariable int id, @RequestBody ContractChatrooms image) {
        image.setContract_chat_id(id);
        contractChatroomsService.update(image);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id) {
        contractChatroomsService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
