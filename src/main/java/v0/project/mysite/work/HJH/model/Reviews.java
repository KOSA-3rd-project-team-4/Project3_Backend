package v0.project.mysite.work.HJH.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter @Setter
public class Reviews {
    private int review_id;
    private int member_id;
    private int bizMember_id;
    private int is_biz_member;
    private String contents;
    private int rating;
}
