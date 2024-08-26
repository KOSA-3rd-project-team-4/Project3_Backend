package v0.project.mysite.work.HJH.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter @Setter
public class Image {
    private int image_id;
    private String image_url;
    private String image_type;
    private int image_size;
}
