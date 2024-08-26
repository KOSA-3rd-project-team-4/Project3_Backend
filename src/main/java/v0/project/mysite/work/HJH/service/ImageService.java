package v0.project.mysite.work.HJH.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import v0.project.mysite.work.HJH.mapper.ImageMapper;
import v0.project.mysite.work.HJH.model.Image;

import java.util.List;

@Service
public class ImageService extends BaseServiceImpl<Image, Integer>{

    private final ImageMapper imageMapper;

    public ImageService(@Qualifier("imageMapper") ImageMapper imageMapper) {
        this.imageMapper = imageMapper;
        assignBaseMapper(this.imageMapper);
    }

    // 필요시 ImageService에 특화된 메서드를 추가할 수 있습니다.
}
