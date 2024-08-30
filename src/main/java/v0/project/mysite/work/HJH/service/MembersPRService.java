package v0.project.mysite.work.HJH.service;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import v0.project.mysite.work.HJH.mapper.MembersMapper;
import v0.project.mysite.work.HJH.mapper.MembersPRMapper;
import v0.project.mysite.work.HJH.model.Members;
import v0.project.mysite.work.HJH.model.MembersPR;

@Service
public class MembersPRService extends BaseServiceImpl<MembersPR, Integer>{

    private final MembersPRMapper membersPRMapper;

    public MembersPRService(@Qualifier("membersPRMapper") MembersPRMapper membersPRMapper) {
        this.membersPRMapper = membersPRMapper;
        assignBaseMapper(this.membersPRMapper);
    }

    // 필요시 MembersService에 특화된 메서드를 추가할 수 있다.
}
