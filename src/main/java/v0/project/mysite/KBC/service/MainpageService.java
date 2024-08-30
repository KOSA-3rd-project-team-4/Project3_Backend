package v0.project.mysite.KBC.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import v0.project.mysite.KBC.DTO.*;
import v0.project.mysite.KBC.repository.MainpageMapper;

import java.util.List;

@Service
public class MainpageService {

    @Autowired
    MainpageMapper mainpageMapper;

    public List<MainAnnounce> joblist() {
        return mainpageMapper.joblist();
    }

    public List<MainAnTag> taglist() {
        return mainpageMapper.taglist();
    }

    public List<MainResume> resumeList() {
        return mainpageMapper.resumeList();
    }

    public List<MainResumeTag> resumeTagList() {
        return mainpageMapper.resumeTagList();
    }

    public List<AllTag> alltag() {
        return mainpageMapper.alltag();
    }

}
