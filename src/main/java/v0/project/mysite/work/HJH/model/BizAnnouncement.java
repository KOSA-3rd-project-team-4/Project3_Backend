package v0.project.mysite.work.HJH.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalTime;

@Data
@Getter @Setter
public class BizAnnouncement {
    private int announcement_id;
    private int bizmember_id;
    private String title;
    private String contents;
    private float salary;
    private LocalDate day_of_work;
    private LocalTime start_work_time;
    private LocalTime end_work_time;
    private String recruit_condition;
    private float work_pos_latitude;
    private float work_pos_longitude;
    private String location_description;
    private int announcement_finished;
}
