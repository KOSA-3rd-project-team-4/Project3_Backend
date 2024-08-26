package v0.project.mysite.work.HJH.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Data
@Getter @Setter
public class MembersPR {
    private int pr_id;
    private int member_id;
    private String title;
    private Timestamp start_time;
    private Timestamp end_time;
    private String contents;
    private int display;
}
