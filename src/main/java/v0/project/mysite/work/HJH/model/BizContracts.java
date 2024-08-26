package v0.project.mysite.work.HJH.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter @Setter
public class BizContracts {
    private int biz_contracts_id;
    private int bizmember_id;
    private int type;
    private String content;
    private int contracts_id;
    private String status;
}
