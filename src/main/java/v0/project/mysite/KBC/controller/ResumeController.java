package v0.project.mysite.KBC.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import v0.project.mysite.KBC.repository.IResumeRepository;
import v0.project.mysite.KBC.repository.IUserRepository;
import v0.project.mysite.KBC.service.UserService;
import v0.project.mysite.work.HJH.model.BizMembers;
import v0.project.mysite.work.HJH.model.Members;
import v0.project.mysite.work.HJH.model.MembersPR;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Log4j2
public class ResumeController {

    private final IResumeRepository resumeRepository;
    private final UserService userService;

    @GetMapping("/api/resume-list")
    public ResponseEntity<List<MembersPR>> getPrInfo() {
            List<MembersPR> prInfo = resumeRepository.selectAllMembersPRWithMembers();
            log.info(prInfo);
            return ResponseEntity.ok(prInfo);
            //return userInfo;
    }

    @GetMapping("/api/member-list")
    public ResponseEntity<List<Members>> getUserInfo() {
        List<Members> userInfo = userService.selectAll();
        log.info(userInfo);
        return ResponseEntity.ok(userInfo);
        //return userInfo;
    }
}
