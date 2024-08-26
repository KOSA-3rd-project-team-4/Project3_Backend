package v0.project.mysite.work.HJH.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Data
@Getter @Setter
public class Members {
    private int member_id;
    private String nick_name;
    private String password;
    private String email;
    private int image_id;
    private int email_verified;
    private Timestamp edit_date;
}
