package v0.project.mysite.KBC.controller;


import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.*;
import v0.project.mysite.KBC.DTO.TestBiz;
import v0.project.mysite.KBC.repository.IUserRepository;
import v0.project.mysite.KBC.service.UserService;
import v0.project.mysite.work.HJH.mapper.MembersMapper;
import v0.project.mysite.work.HJH.model.BizMembers;
import v0.project.mysite.work.HJH.model.Members;
import v0.project.mysite.work.HJH.service.MembersService;

@RestController
@RequiredArgsConstructor
@Log4j2
public class UserController {

    private final IUserRepository userRepository;
    private final MembersMapper membersMapper;

    @GetMapping("/api/user")
    public ResponseEntity<?> getUserInfo() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        log.info("Authentication object: {}", authentication);

        if (authentication != null && authentication.isAuthenticated()) {
            Object principal = authentication.getPrincipal();

            // OAuth2 로그인 처리
            if (principal instanceof OAuth2User) {
                OAuth2User oAuth2User = (OAuth2User) principal;
                String username = oAuth2User.getAttribute("name"); // OAuth2User에서 이름을 가져옴
                log.info("OAuth2 username: {}", username);

                if (username != null) {
                    Members existingMember = membersMapper.selectByUsername(username);
                    log.info("Fetched Member: {}", existingMember);

                    if (existingMember != null) {
                        return ResponseEntity.ok(existingMember);
                    } else {
                        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
                    }
                }

                // 일반 로그인 처리
            } else if (principal instanceof UserDetails) {
                UserDetails userDetails = (UserDetails) principal;
                String username = userDetails.getUsername();
                log.info("UserDetails username: {}", username);

                BizMembers userInfo = userRepository.getBizMember(username);
                log.info("Fetched BizMember: {}", userInfo);

                if (userInfo != null) {
                    return ResponseEntity.ok(userInfo);
                } else {
                    return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
                }
            }
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
    }

    @GetMapping("/current-user")
    public String getCurrentUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication != null && authentication.isAuthenticated()) {
            Object principal = authentication.getPrincipal();

            if (principal instanceof OAuth2User) {
                OAuth2User oAuth2User = (OAuth2User) principal;
                return "Logged in as: " + oAuth2User.getAttribute("name");
            } else if (principal instanceof UserDetails) {
                UserDetails userDetails = (UserDetails) principal;
                return "Logged in as: " + userDetails.getUsername();
            } else {
                return "Logged in as: " + principal.toString();
            }
        } else {
            return "Not logged in";
        }
    }
}
