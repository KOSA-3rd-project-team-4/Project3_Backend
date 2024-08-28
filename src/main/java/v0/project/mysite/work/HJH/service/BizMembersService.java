package v0.project.mysite.work.HJH.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import v0.project.mysite.work.HJH.mapper.BizMembersMapper;
import v0.project.mysite.work.HJH.mapper.ImageMapper;
import v0.project.mysite.work.HJH.model.BizMembers;
import v0.project.mysite.work.HJH.model.Image;

@Service
public class BizMembersService extends BaseServiceImpl<BizMembers, Integer>{

    private final BizMembersMapper bizMembersMapper;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public BizMembersService(BizMembersMapper bizMembersMapper, PasswordEncoder passwordEncoder) {
        this.bizMembersMapper = bizMembersMapper;
        this.passwordEncoder = passwordEncoder;
        assignBaseMapper(this.bizMembersMapper);
    }

    public void insert(BizMembers bizMembers) {
        // 비밀번호 암호화
        String encodedPassword = passwordEncoder.encode(bizMembers.getPassword());
        bizMembers.setPassword(encodedPassword);

        bizMembersMapper.insert(bizMembers);
    }
    // 필요시 ImageService에 특화된 메서드를 추가할 수 있습니다.
}
