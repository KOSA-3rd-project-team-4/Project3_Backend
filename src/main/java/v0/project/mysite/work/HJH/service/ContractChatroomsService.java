package v0.project.mysite.work.HJH.service;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import v0.project.mysite.work.HJH.mapper.ContractChatroomsMapper;
import v0.project.mysite.work.HJH.mapper.ImageMapper;
import v0.project.mysite.work.HJH.model.ContractChatrooms;
import v0.project.mysite.work.HJH.model.Image;

@Service
public class ContractChatroomsService extends BaseServiceImpl<ContractChatrooms, Integer>{

    private final ContractChatroomsMapper contractChatroomsMapper;

    public ContractChatroomsService(@Qualifier("contractChatroomsMapper") ContractChatroomsMapper contractChatroomsMapper) {
        this.contractChatroomsMapper = contractChatroomsMapper;
        assignBaseMapper(this.contractChatroomsMapper);
    }

    // 필요시 ImageService에 특화된 메서드를 추가할 수 있습니다.
}
