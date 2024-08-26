package v0.project.mysite.work.HJH.service;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import v0.project.mysite.work.HJH.mapper.FilteringTagsMapper;
import v0.project.mysite.work.HJH.mapper.ImageMapper;
import v0.project.mysite.work.HJH.model.FilteringTags;
import v0.project.mysite.work.HJH.model.Image;

@Service
public class FilteringTagsService extends BaseServiceImpl<FilteringTags, Integer>{

    private final FilteringTagsMapper filteringTagsMapper;

    public FilteringTagsService(@Qualifier("filteringTagsMapper") FilteringTagsMapper filteringTagsMapper) {
        this.filteringTagsMapper = filteringTagsMapper;
        assignBaseMapper(this.filteringTagsMapper);
    }

    // 필요시 ImageService에 특화된 메서드를 추가할 수 있습니다.
}
