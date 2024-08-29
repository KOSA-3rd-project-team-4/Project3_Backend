package v0.project.mysite.work.HJH.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import v0.project.mysite.work.HJH.model.Applies;
import v0.project.mysite.work.HJH.model.ViewAnnouncement;
import v0.project.mysite.work.HJH.service.ViewAnnouncementsService;

import java.util.List;

@RestController
@RequestMapping("/query/view/announcements")
@RequiredArgsConstructor
public class View_AnnouncementsController {

    private final ViewAnnouncementsService vaService;

    @GetMapping("/select/all")
    public List<ViewAnnouncement> selectAll() {
        return vaService.selectAll();
    }

    @GetMapping("/select/{id}")
    public ViewAnnouncement selectById(@PathVariable int id) {
        return vaService.selectById(id);
    }
}
