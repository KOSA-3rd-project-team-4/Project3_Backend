package v0.project.mysite.work.HJH.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter @Setter
public class ChatLogs {
    private int chat_log_id;
    private int contract_chat_id;
    private int is_biz_member;
    private int sent_by;
    private String content;
    private String chat_time;
}
