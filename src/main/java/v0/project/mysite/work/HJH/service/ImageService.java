package v0.project.mysite.work.HJH.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import v0.project.mysite.work.HJH.mapper.ImageMapper;
import v0.project.mysite.work.HJH.model.Image;

import java.util.List;

@Service
public class ImageService extends BaseServiceImpl<Image, Integer>{

    public ImageService(ImageMapper imageMapper) {
        super(imageMapper);
    }

    // 필요시 ImageService에 특화된 메서드를 추가할 수 있습니다.
}
