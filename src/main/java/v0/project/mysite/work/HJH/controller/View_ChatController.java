package v0.project.mysite.work.HJH.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
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
}
