package v0.project.mysite.work.HJH.service.converter;


import v0.project.mysite.work.HJH.controller.dto.EducationDTO;
import v0.project.mysite.work.HJH.model.PR.Education;

import java.util.ArrayList;
import java.util.List;

public class EducationConverter {

    /**
     * Converts an EducationDTO object to an Education object.
     *
     * @param dto the EducationDTO object to be converted
     * @param prId the pr_id to be set in the Education object
     * @return a new Education object with the converted fields
     */
    public static Education convertToEducation(EducationDTO dto, int prId) {
        Education education = new Education();

        // Set fields in the new Education object
        education.setPr_id(prId);
        education.setSchool(dto.getSchool());
        education.setPeriod(dto.getPeriod());
        education.setMajor(dto.getMajor());

        return education;
    }

    /**
     * Converts a list of EducationDTO objects to a list of Education objects.
     *
     * @param dtoList the list of EducationDTO objects to be converted
     * @param prId the pr_id to be set in each Education object
     * @return a list of Education objects with the converted fields
     */
    public static List<Education> convertToEducationList(List<EducationDTO> dtoList, int prId) {
        List<Education> educationList = new ArrayList<>();

        for (EducationDTO dto : dtoList) {
            educationList.add(convertToEducation(dto, prId));
        }

        return educationList;
    }
}
