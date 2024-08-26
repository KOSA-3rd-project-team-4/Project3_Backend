package v0.project.mysite.work.HJH.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter @Setter
public class FilteringTags {
    private int tag_filter_id;
    private String tag_name;
}
