package v0.project.mysite.work.HJH.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Qualifier;
import v0.project.mysite.work.HJH.model.BaseElectronicContracts;

@Mapper
@Qualifier("bizElectronicContractsMapper")
public interface BaseElectronicContractsMapper extends BaseMapper<BaseElectronicContracts, Integer>{
    // 필요시 ImageMapper에 특화된 메서드를 추가할 수 있습니다.
}
