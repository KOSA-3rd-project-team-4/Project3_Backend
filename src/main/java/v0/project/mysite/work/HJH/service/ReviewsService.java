package v0.project.mysite.work.HJH.service;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import v0.project.mysite.work.HJH.mapper.ImageMapper;
import v0.project.mysite.work.HJH.mapper.ReviewsMapper;
import v0.project.mysite.work.HJH.model.Image;
import v0.project.mysite.work.HJH.model.Reviews;

@Service
public class ReviewsService extends BaseServiceImpl<Reviews, Integer>{

    private final ReviewsMapper reviewsMapper;

    public ReviewsService(@Qualifier("reviewsMapper") ReviewsMapper reviewsMapper) {
        this.reviewsMapper = reviewsMapper;
        assignBaseMapper(this.reviewsMapper);
    }

    // 필요시 ImageService에 특화된 메서드를 추가할 수 있습니다.
}
