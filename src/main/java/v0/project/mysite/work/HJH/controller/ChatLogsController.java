package v0.project.mysite.work.HJH.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import v0.project.mysite.work.HJH.model.ChatLogs;
import v0.project.mysite.work.HJH.model.Image;
import v0.project.mysite.work.HJH.service.ChatLogsService;
import v0.project.mysite.work.HJH.service.ImageService;

import java.util.List;

@RestController
@RequestMapping("/query/chatlogs")
public class ChatLogsController {

    private final ChatLogsService chatLogsService;

    public ChatLogsController(ChatLogsService chatLogsService) {
        this.chatLogsService = chatLogsService;
    }

    @GetMapping("/select/{id}")
    public ResponseEntity<ChatLogs> selectById(@PathVariable int id) {
        ChatLogs image = chatLogsService.selectById(id);
        return ResponseEntity.ok(image);
    }

    @GetMapping("/select/all")
    public ResponseEntity<List<ChatLogs>> selectAll() {
        List<ChatLogs> images = chatLogsService.selectAll();
        return ResponseEntity.ok(images);
    }

    @PostMapping("/insert")
    public ResponseEntity<ChatLogs> insert(@RequestBody ChatLogs image) {
        chatLogsService.insert(image);
        return ResponseEntity.status(201).body(image);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Void> update(@PathVariable int id, @RequestBody ChatLogs image) {
        image.setChat_log_id(id);
        chatLogsService.update(image);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id) {
        chatLogsService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
