package v0.project.mysite.work.HJH.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import v0.project.mysite.work.HJH.controller.dto.EducationDTO;
import v0.project.mysite.work.HJH.controller.dto.ExperienceDTO;
import v0.project.mysite.work.HJH.controller.dto.MPR;
import v0.project.mysite.work.HJH.mapper.*;
import v0.project.mysite.work.HJH.model.PR.*;
import v0.project.mysite.work.HJH.service.converter.EducationConverter;
import v0.project.mysite.work.HJH.service.converter.ExperienceConverter;
import v0.project.mysite.work.HJH.service.converter.MPRConverter;
import v0.project.mysite.work.HJH.service.converter.MPRToNewMembersPRConverter;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MembersPRService{

    private final MembersPRMapper membersPRMapper;
    private final PReducationMapper pReducationMapper;
    private final PRexperienceMapper pRexperienceMapper;
    private final PRtagsMapper prtagsMapper;
    private final PRdaysMapper prdaysMapper;

    public List<NewMembersPR> selectAll(){
        return membersPRMapper.selectAll();
    }

    public MPR selectById(int id){
        NewMembersPR newMembersPR = membersPRMapper.selectById(id);
        List<Education> educationList = pReducationMapper.findById(id);
        List<Experience> experienceList = pRexperienceMapper.findById(id);
        List<Available_days> availableDaysList = prdaysMapper.findById(id);
        List<Tags> tagsList = prtagsMapper.findById(id);
        return MPRConverter.convertFromNewMembersPR(newMembersPR, educationList, experienceList, availableDaysList, tagsList);
    }

    public void insert(MPR membersPR, int user_id){
        List<EducationDTO> educationList = membersPR.getEducation();
        List<ExperienceDTO> experienceList = membersPR.getExperience();
        List<String> days = membersPR.getAvailableDays();
        List<String> tags = membersPR.getTags();

        // 변환
        NewMembersPR newMembersPR = MPRToNewMembersPRConverter.convert(membersPR, user_id);
        membersPRMapper.insert(newMembersPR);   // 저장


        System.out.println(newMembersPR.getPr_id());

        for (EducationDTO educationdto : educationList) {
            Education education = EducationConverter.convertToEducation(educationdto, newMembersPR.getPr_id());
            pReducationMapper.insert(education);
        }

        for (ExperienceDTO experiencedto : experienceList) {
            Experience experience = ExperienceConverter.convertToExperience(experiencedto, newMembersPR.getPr_id());
            pRexperienceMapper.insert(experience);
        }

        for (String day : days) {
            Available_days d = new Available_days();
            d.setDay(day);
            d.setPr_id(newMembersPR.getPr_id());
            prdaysMapper.insert(d);
        }

        for(String tag : tags){
            Tags t = new Tags();
            t.setPr_id(newMembersPR.getPr_id());
            t.setTag(tag);
            prtagsMapper.insert(t);
        }

    }

    public void update(MPR membersPR, int user_id){
        List<EducationDTO> educationList = membersPR.getEducation();
        List<ExperienceDTO> experienceList = membersPR.getExperience();
        List<String> days = membersPR.getAvailableDays();
        List<String> tags = membersPR.getTags();

        // 변환
        NewMembersPR newMembersPR = MPRToNewMembersPRConverter.convert(membersPR, user_id);
        membersPRMapper.update(newMembersPR);   // 업데이트

        prdaysMapper.delete(newMembersPR.getPr_id());
        pReducationMapper.delete(newMembersPR.getPr_id());
        prtagsMapper.delete(newMembersPR.getPr_id());
        pRexperienceMapper.delete(newMembersPR.getPr_id());

        for (EducationDTO educationdto : educationList) {
            Education education = EducationConverter.convertToEducation(educationdto, newMembersPR.getPr_id());
            pReducationMapper.insert(education);
        }

        for (ExperienceDTO experiencedto : experienceList) {
            Experience experience = ExperienceConverter.convertToExperience(experiencedto, newMembersPR.getPr_id());
            pRexperienceMapper.insert(experience);
        }

        for (String day : days) {
            Available_days d = new Available_days();
            d.setDay(day);
            d.setPr_id(newMembersPR.getPr_id());
            prdaysMapper.insert(d);
        }

        for(String tag : tags){
            Tags t = new Tags();
            t.setPr_id(newMembersPR.getPr_id());
            t.setTag(tag);
            prtagsMapper.insert(t);
        }
    }

    public void delete(int id) {
        prdaysMapper.delete(id);
        pReducationMapper.delete(id);
        prtagsMapper.delete(id);
        pRexperienceMapper.delete(id);

        membersPRMapper.delete(id);
    }

    public List<NewMembersPR> selectUser(int id) {
        return membersPRMapper.selectUser(id);
    }

    //public
    // 필요시 MembersService에 특화된 메서드를 추가할 수 있다.
}
