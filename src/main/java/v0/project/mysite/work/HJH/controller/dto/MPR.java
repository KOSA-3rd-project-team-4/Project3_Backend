package v0.project.mysite.work.HJH.controller.dto;

import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Getter
@Setter
public class MPR {

    private int id;
    private String title;
    private String photo;
    private String name;
    private String gender;
    private LocalDate birthDay;
    private String contact;
    private String address;
    private List<EducationDTO> education;
    private List<ExperienceDTO> experience;
    private String contents;
    private List<String> availableDays;
    private LocalTime startTime;
    private LocalTime endTime;
    private List<String> tags;
    private int display;

}

