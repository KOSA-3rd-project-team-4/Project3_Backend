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
import v0.project.mysite.work.HJH.model.BizMembers;

@RestController
@RequiredArgsConstructor
@Log4j2
public class UserController {

    private final UserService userService;
    private final IUserRepository userRepository;

    @GetMapping("/api/user")
    public ResponseEntity<BizMembers> getUserInfo() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        log.info(authentication);
        if (authentication != null && authentication.isAuthenticated()) {
            Object principal = authentication.getPrincipal();
            UserDetails user = (UserDetails) principal;
            BizMembers userInfo = userRepository.getBizMember(user.getUsername());
            log.info(userInfo.getUsername());
            return ResponseEntity.ok(userInfo);
            //return userInfo;
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
