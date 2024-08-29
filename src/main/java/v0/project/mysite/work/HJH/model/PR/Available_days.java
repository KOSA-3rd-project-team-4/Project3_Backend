package v0.project.mysite.work.HJH.model.PR;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class Available_days {
    private int day_id;
    private int pr_id;
    private String day;
}
