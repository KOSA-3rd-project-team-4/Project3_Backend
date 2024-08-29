package v0.project.mysite.work.HJH.service.converter;

import v0.project.mysite.work.HJH.controller.dto.EducationDTO;
import v0.project.mysite.work.HJH.controller.dto.ExperienceDTO;
import v0.project.mysite.work.HJH.controller.dto.MPR;
import v0.project.mysite.work.HJH.model.PR.*;

import java.util.List;
import java.util.stream.Collectors;

public class MPRConverter {
    public static MPR convertFromNewMembersPR(NewMembersPR newMembersPR,
                                              List<Education> educationList,
                                              List<Experience> experienceList,
                                              List<Available_days> availableDaysList,
                                              List<Tags> tagsList) {
        MPR mpr = new MPR();
        mpr.setId(newMembersPR.getPr_id());
        mpr.setTitle(newMembersPR.getTitle());
        mpr.setName(newMembersPR.getName());
        mpr.setGender(newMembersPR.getGender());
        mpr.setBirthDay(newMembersPR.getBirthday());
        mpr.setContact(newMembersPR.getContact());
        mpr.setAddress(newMembersPR.getAddress());
        mpr.setContents(newMembersPR.getContents());
        mpr.setStartTime(newMembersPR.getStart_time());
        mpr.setEndTime(newMembersPR.getEnd_time());
        mpr.setDisplay(newMembersPR.getDisplay());

        // Convert Education entities to DTOs
        List<EducationDTO> educationDTOs = educationList.stream()
                .map(e -> {
                    EducationDTO dto = new EducationDTO();
                    dto.setSchool(e.getSchool());
                    dto.setMajor(e.getMajor());
                    dto.setPeriod(e.getPeriod());
                    return dto;
                }).collect(Collectors.toList());
        mpr.setEducation(educationDTOs);

        // Convert Experience entities to DTOs
        List<ExperienceDTO> experienceDTOs = experienceList.stream()
                .map(e -> {
                    ExperienceDTO dto = new ExperienceDTO();
                    dto.setCompany(e.getCompany());
                    dto.setRole(e.getRole());
                    dto.setPeriod(e.getPeriod());
                    dto.setDescription(e.getDescription());
                    return dto;
                }).collect(Collectors.toList());
        mpr.setExperience(experienceDTOs);

        // Convert Available_days entities to List of Strings
        List<String> availableDays = availableDaysList.stream()
                .map(Available_days::getDay)
                .collect(Collectors.toList());
        mpr.setAvailableDays(availableDays);

        // Convert Tags entities to List of Strings
        List<String> tags = tagsList.stream()
                .map(Tags::getTag)
                .collect(Collectors.toList());
        mpr.setTags(tags);

        return mpr;
    }
}
