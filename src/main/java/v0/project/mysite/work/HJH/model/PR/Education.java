package v0.project.mysite.work.HJH.model.PR;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class Education {
    private int education_id;
    private int pr_id;
    private String school;
    private String period;
    private String major;
}