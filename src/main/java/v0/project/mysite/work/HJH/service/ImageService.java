package v0.project.mysite.work.HJH.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import v0.project.mysite.work.HJH.mapper.ImageMapper;
import v0.project.mysite.work.HJH.model.Image;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ImageService {

    private final ImageMapper imageMapper;

    public Image selectImageById(int id) {
        return imageMapper.selectById(id);
    }

    public List<Image> selectAllImage() {
        return imageMapper.selectAll();
    }

    public void insertImage(Image image) {
        imageMapper.insert(image);
    }

    public void updateImage(Image image) {
        imageMapper.update(image);
    }

    public void deleteImage(int id) {
        imageMapper.delete(id);
    }
}
