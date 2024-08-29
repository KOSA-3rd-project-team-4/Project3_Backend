package v0.project.mysite.work.HJH.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import v0.project.mysite.work.HJH.model.ViewAnnouncement;
import v0.project.mysite.work.HJH.model.ViewBizMembersApplies;
import v0.project.mysite.work.HJH.service.ViewAnnouncementsService;
import v0.project.mysite.work.HJH.service.ViewBizMembersAppliesService;

import java.util.List;

@RestController
@RequestMapping("/query/view/bizmember/applies")
@RequiredArgsConstructor
public class View_BizMembersAppliesController {

    private final ViewBizMembersAppliesService vbmaService;

    @GetMapping("/select/{id}")
    public List<ViewBizMembersApplies> selectById(@PathVariable int id) {
        return vbmaService.selectById(id);
    }
}
