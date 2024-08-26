package v0.project.mysite.work.HJH.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import v0.project.mysite.work.HJH.mapper.ImageMapper;
import v0.project.mysite.work.HJH.mapper.MembersMapper;
import v0.project.mysite.work.HJH.model.Image;
import v0.project.mysite.work.HJH.model.Members;

import java.util.List;

@Service
public class MembersService extends BaseServiceImpl<Members, Integer>{

    private final MembersMapper membersMapper;

    public MembersService(@Qualifier("membersMapper") MembersMapper membersMapper) {
        this.membersMapper = membersMapper;
        assignBaseMapper(this.membersMapper);
    }

    // 필요시 MembersService에 특화된 메서드를 추가할 수 있다.
}
