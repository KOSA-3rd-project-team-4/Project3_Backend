package v0.project.mysite.work.HJH.mapper;

import org.apache.ibatis.annotations.Mapper;
import v0.project.mysite.work.HJH.model.Image;

import java.util.List;

@Mapper
public interface ImageMapper extends BaseMapper<Image, Integer>{
    // 필요시 ImageMapper에 특화된 메서드를 추가할 수 있습니다.
}
