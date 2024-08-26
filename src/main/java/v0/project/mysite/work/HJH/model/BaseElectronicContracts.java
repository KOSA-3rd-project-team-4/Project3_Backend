package v0.project.mysite.work.HJH.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter @Setter
public class BaseElectronicContracts {
    private int contracts_id;
    private int type;
    private String content;
}
