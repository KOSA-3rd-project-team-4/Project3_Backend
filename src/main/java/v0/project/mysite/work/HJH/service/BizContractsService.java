package v0.project.mysite.work.HJH.service;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import v0.project.mysite.work.HJH.mapper.BizContractsMapper;
import v0.project.mysite.work.HJH.mapper.ImageMapper;
import v0.project.mysite.work.HJH.model.BizContracts;
import v0.project.mysite.work.HJH.model.Image;

@Service
public class BizContractsService extends BaseServiceImpl<BizContracts, Integer>{

    private final BizContractsMapper bizContractsMapper;

    public BizContractsService(@Qualifier("bizContractsMapper") BizContractsMapper bizContractsMapper) {
        this.bizContractsMapper = bizContractsMapper;
        assignBaseMapper(this.bizContractsMapper);
    }

    // 필요시 ImageService에 특화된 메서드를 추가할 수 있습니다.
}
