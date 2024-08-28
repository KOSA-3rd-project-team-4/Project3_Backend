package v0.project.mysite.work.HJH.service;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import v0.project.mysite.work.HJH.mapper.BizMembersMapper;
import v0.project.mysite.work.HJH.mapper.ImageMapper;
import v0.project.mysite.work.HJH.model.BizMembers;
import v0.project.mysite.work.HJH.model.Image;

@Service
public class BizMembersService extends BaseServiceImpl<BizMembers, Integer>{

    private final BizMembersMapper bizMembersMapper;

    public BizMembersService(@Qualifier("bizMembersMapper") BizMembersMapper bizMembersMapper) {
        this.bizMembersMapper = bizMembersMapper;
        assignBaseMapper(this.bizMembersMapper);
    }


    // 필요시 ImageService에 특화된 메서드를 추가할 수 있습니다.
}
