package v0.project.mysite.work.HJH.controller;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import v0.project.mysite.work.HJH.mapper.BizMembersMapper;
import v0.project.mysite.work.HJH.model.BizMembers;
import v0.project.mysite.work.HJH.service.BizMembersService;
import java.util.List;

@Log4j2
@RestController
@RequestMapping("/query/bizmembers")
public class BizMembersController {

    private final BizMembersMapper bizMembersMapper;
    private final PasswordEncoder passwordEncoder;
    private final BizMembersService bizMembersService;

    public BizMembersController(BizMembersMapper bizMembersMapper, PasswordEncoder passwordEncoder, BizMembersService bizMembersService) {
            this.bizMembersMapper = bizMembersMapper;
            this.passwordEncoder = passwordEncoder;
            this.bizMembersService = bizMembersService;
        }

        @GetMapping("/select/{id}")
        public ResponseEntity<BizMembers> selectById ( @PathVariable int id){
            BizMembers image = bizMembersMapper.selectById(id);
            return ResponseEntity.ok(image);
        }

        @GetMapping("/select/all")
        public ResponseEntity<List<BizMembers>> selectAll () {
            List<BizMembers> images = bizMembersMapper.selectAll();
            return ResponseEntity.ok(images);
        }

        @PostMapping("/insert")
        public ResponseEntity<BizMembers> insert (@RequestBody BizMembers image){
            bizMembersMapper.insert(image);
            return ResponseEntity.status(201).body(image);
        }

        @PutMapping("/update/{id}")
        public ResponseEntity<Void> update ( @PathVariable int id, @RequestBody BizMembers image){
            image.setBizmember_id(id);
            bizMembersService.update(image);
            return ResponseEntity.noContent().build();
        }

        @DeleteMapping("/delete/{id}")
        public ResponseEntity<Void> delete ( @PathVariable int id){
            bizMembersMapper.delete(id);
            return ResponseEntity.noContent().build();
        }

        @GetMapping("/findByEmail")
        public ResponseEntity<String> findByEmail (@RequestParam String email){
            BizMembers bizMember = bizMembersMapper.findByEmail(email);
            log.info(" bizMember: {}", bizMember);
            if (bizMember != null) {
                return ResponseEntity.ok(bizMember.getUsername());
            } else {
                return ResponseEntity.status(404).body("아이디를 찾을 수 없습니다.");
            }
        }

        @PostMapping("/findPassword")
        public ResponseEntity<?> findPassword (@RequestBody FindPasswordRequest request){
            BizMembers bizMember = bizMembersMapper.findByUsernameAndEmail(request.getUsername(), request.getEmail());
            if (bizMember != null) {
                return ResponseEntity.ok("아이디와 이메일이 확인되었습니다. 새 비밀번호를 입력하세요.");
            } else {
                return ResponseEntity.status(404).body("일치하는 계정을 찾을 수 없습니다.");
            }
        }

        @PostMapping("/resetPassword")
        public ResponseEntity<?> resetPassword (@RequestBody ResetPasswordRequest request){
            BizMembers bizMember = bizMembersMapper.findByUsernameAndEmail(request.getUsername(), request.getEmail());
            if (bizMember != null) {
                String encodedPassword = passwordEncoder.encode(request.getNewPassword());
                bizMember.setPassword(encodedPassword);
                bizMembersMapper.update(bizMember);
                return ResponseEntity.ok("비밀번호가 성공적으로 변경되었습니다.");
            } else {
                return ResponseEntity.status(404).body("일치하는 계정을 찾을 수 없습니다.");
            }
        }
    }

    @Getter
    @Setter
    class FindPasswordRequest {
        private String username;
        private String email;
    }

    @Getter
    @Setter
    class ResetPasswordRequest {
        private String username;
        private String email;
        private String newPassword;
    }
