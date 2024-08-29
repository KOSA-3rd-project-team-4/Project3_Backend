package v0.project.mysite.work.HJH.service.converter;

import v0.project.mysite.work.HJH.controller.dto.ExperienceDTO;
import v0.project.mysite.work.HJH.model.PR.Experience;

import java.util.ArrayList;
import java.util.List;

public class ExperienceConverter {

    /**
     * Converts an ExperienceDTO object to an Experience object.
     *
     * @param dto the ExperienceDTO object to be converted
     * @param prId the pr_id to be set in the Experience object
     * @return a new Experience object with the converted fields
     */
    public static Experience convertToExperience(ExperienceDTO dto, int prId) {
        Experience experience = new Experience();

        // Set fields in the new Experience object
        experience.setPr_id(prId);
        experience.setCompany(dto.getCompany());
        experience.setRole(dto.getRole());
        experience.setPeriod(dto.getPeriod());
        experience.setDescription(dto.getDescription());

        return experience;
    }

    /**
     * Converts a list of ExperienceDTO objects to a list of Experience objects.
     *
     * @param dtoList the list of ExperienceDTO objects to be converted
     * @param prId the pr_id to be set in each Experience object
     * @return a list of Experience objects with the converted fields
     */
    public static List<Experience> convertToExperienceList(List<ExperienceDTO> dtoList, int prId) {
        List<Experience> experienceList = new ArrayList<>();

        for (ExperienceDTO dto : dtoList) {
            experienceList.add(convertToExperience(dto, prId));
        }

        return experienceList;
    }
}
