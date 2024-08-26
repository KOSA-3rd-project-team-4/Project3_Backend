package v0.project.mysite.work.HJH.service;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import v0.project.mysite.work.HJH.mapper.ImageMapper;
import v0.project.mysite.work.HJH.mapper.TagListsMapper;
import v0.project.mysite.work.HJH.model.Image;
import v0.project.mysite.work.HJH.model.TagLists;

@Service
public class TagListsService extends BaseServiceImpl<TagLists, Integer>{

    private final TagListsMapper tagListsMapper;

    public TagListsService(@Qualifier("tagListsMapper") TagListsMapper tagListsMapper) {
        this.tagListsMapper = tagListsMapper;
        assignBaseMapper(this.tagListsMapper);
    }

    // 필요시 ImageService에 특화된 메서드를 추가할 수 있습니다.
}
