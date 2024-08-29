package v0.project.mysite.work.HJH.model.PR;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Data
@Getter
@Setter
public class NewMembersPR {

    private int pr_id;              // 고유 아이디
    private int member_id;          // 사용자 아이디
    private String title;           // 제목
    private int photo_id;           // 이력서 사진 아이디 (Image 에 저장후 해당 아이디만 가져와서 저장)
    private String name;            // 이름
    private String gender;          // 성별
    private LocalDate birthday;     // 생년월일
    private String contact;         // 전화번호
    private String address;         // 주소

    private LocalTime start_time;   // 시작 시간
    private LocalTime end_time;     // 종료 시간
    private String contents;        // 동기

    private int display;            // 공개 여부

}