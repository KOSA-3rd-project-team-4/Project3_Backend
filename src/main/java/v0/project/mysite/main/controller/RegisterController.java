package v0.project.mysite.main.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import v0.project.mysite.work.HJH.model.BizMembers;
import v0.project.mysite.work.HJH.service.BizMembersService;

@RestController
@RequestMapping("/api")
public class RegisterController {

    private final BizMembersService bizMembersService;

    public RegisterController(BizMembersService bizMembersService) {
        this.bizMembersService = bizMembersService;
    }

    @PostMapping("/register")
    public ResponseEntity<Void> register(@RequestBody BizMembers bizMembers) {
        System.out.println(bizMembers);
        bizMembersService.insert(bizMembers);
        return ResponseEntity.status(201).build();
    }
}