package v0.project.mysite.work.HJH.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import v0.project.mysite.work.HJH.model.ViewAnnouncement;
import v0.project.mysite.work.HJH.model.ViewChat;
import v0.project.mysite.work.HJH.service.ViewAnnouncementsService;
import v0.project.mysite.work.HJH.service.ViewChatService;

import java.util.List;

@RestController
@RequestMapping("/query/view/chat")
@RequiredArgsConstructor
public class View_ChatController {

    private final ViewChatService vcService;

    @GetMapping("/select/{id}")
    public List<ViewChat> selectById(@PathVariable int id) {
        return vcService.selectById(id);
    }

    @PutMapping("/update/hire/{contract_chat_id}/{hire}")
    public void updateUserHired(@PathVariable int contract_chat_id, @PathVariable int hire) {
        vcService.updateUserHired(contract_chat_id, hire);
    }
}
