package v0.project.mysite.work.HJH.service;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import v0.project.mysite.work.HJH.mapper.BaseElectronicContractsMapper;
import v0.project.mysite.work.HJH.model.BaseElectronicContracts;

@Service
public class BaseElectronicContractsService extends BaseServiceImpl<BaseElectronicContracts, Integer>{

    private final BaseElectronicContractsMapper baseElectronicContractsMapper;

    public BaseElectronicContractsService(@Qualifier("baseElectronicContractsMapper") BaseElectronicContractsMapper baseElectronicContractsMapper) {
        this.baseElectronicContractsMapper = baseElectronicContractsMapper;
        assignBaseMapper(this.baseElectronicContractsMapper);
    }

    // 필요시 ImageService에 특화된 메서드를 추가할 수 있습니다.
}
