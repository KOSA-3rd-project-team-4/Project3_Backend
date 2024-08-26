package v0.project.mysite.work.HJH.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Data
@Getter @Setter
public class Applies {
    private int apply_id;
    private int member_id;
    private int announcement_id;
    private int chat_created;
    private int user_hired;
    private Timestamp apply_date;
}
