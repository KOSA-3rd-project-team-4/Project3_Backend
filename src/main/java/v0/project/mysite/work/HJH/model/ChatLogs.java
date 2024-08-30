package v0.project.mysite.work.HJH.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Data
@Getter @Setter
public class ChatLogs {
    private int chat_log_id;
    private int contract_chat_id;
    private Integer sent_by_member_id;
    private Integer sent_by_biz_member_id;
    private String content;
    private Timestamp chat_time;
}
