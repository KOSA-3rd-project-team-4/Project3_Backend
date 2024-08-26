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

    public Image selectById(int id) {
        return imageMapper.selectById(id);
    }

    public List<Image> selectAll() {
        return imageMapper.selectAll();
    }

    public void insert(Image image) {
        imageMapper.insert(image);
    }

    public void update(Image image) {
        imageMapper.update(image);
    }

    public void delete(int id) {
        imageMapper.delete(id);
    }
}
