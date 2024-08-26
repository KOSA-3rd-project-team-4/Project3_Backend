package v0.project.mysite.work.HJH.mapper;

import org.apache.ibatis.annotations.Mapper;
import v0.project.mysite.work.HJH.model.Image;

import java.util.List;

@Mapper
public interface ImageMapper {

    Image selectById(int id);

    List<Image> selectAll();

    void insert(Image image);

    void update(Image image);

    void delete(int id);
}
