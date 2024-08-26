package v0.project.mysite.work.HJH.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Data
@Getter @Setter
public class ContractChatrooms {
    private int contract_chat_id;
    private int apply_id;
    private Timestamp room_opening_time;
}
