package v0.project.mysite.work.HJH.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Data
@Getter @Setter
public class ViewChat {
    private int chat_log_id;
    private int contract_chat_id;
    private String sender_name;
    private String content;
    private Timestamp chat_time;

    private Integer sent_by_member_id;
    private Integer sent_by_biz_member_id;
}
