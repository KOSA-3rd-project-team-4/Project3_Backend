package v0.project.mysite.work.HJH.service.converter;

import v0.project.mysite.work.HJH.controller.dto.MPR;
import v0.project.mysite.work.HJH.model.PR.NewMembersPR;

import java.util.Objects;

public class MPRToNewMembersPRConverter {

    public static NewMembersPR convert(MPR mpr, int user_id) {
        NewMembersPR newMembersPR = new NewMembersPR();

        newMembersPR.setPr_id(mpr.getId());  // 고유 아이디를 설정
        newMembersPR.setMember_id(user_id); // 사용자 아이디를 0으로 설정하거나 실제 사용자 ID로 설정
        newMembersPR.setTitle(mpr.getTitle());
        newMembersPR.setPhoto_id(1); // 사진 ID를 0으로 설정하거나 실제 ID로 설정
        newMembersPR.setName(mpr.getName());
        if(Objects.equals(mpr.getGender(), "female")){
            newMembersPR.setGender("F");
        } else if (Objects.equals(mpr.getGender(), "male")) {
            newMembersPR.setGender("M");
        } else {
            newMembersPR.setGender("N");
        }
        //newMembersPR.setGender(mpr.getGender());
        newMembersPR.setBirthday(mpr.getBirthDay()); // LocalDate 타입 그대로 설정
        newMembersPR.setContact(mpr.getContact());
        newMembersPR.setAddress(mpr.getAddress());
        newMembersPR.setStart_time(mpr.getStartTime());
        newMembersPR.setEnd_time(mpr.getEndTime());
        newMembersPR.setContents(mpr.getContents());
        newMembersPR.setDisplay(mpr.getDisplay()); // 공개 여부를 int 타입으로 설정

        return newMembersPR;
    }
}
