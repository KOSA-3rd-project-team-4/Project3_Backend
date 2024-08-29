package v0.project.mysite.work.HJH.model.PR;

import lombok.*;

@Data
@Getter
@Setter
public class Experience {
    private int experience_id;
    private int pr_id;
    private String company;
    private String role;
    private String period;
    private String description;
}
