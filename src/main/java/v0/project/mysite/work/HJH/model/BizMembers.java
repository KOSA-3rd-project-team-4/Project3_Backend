package v0.project.mysite.work.HJH.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Data
@Getter @Setter
public class BizMembers {
    private int bizmember_id;
    private String username;
    private String password;
    private String email;
    private int bizrno;
    private String address;
    private String bizname;
    private String call_number;
    private float rating;
    private float base_latitude;
    private float base_longitude;
    private int image_id;
    private Timestamp date_joined;
}
