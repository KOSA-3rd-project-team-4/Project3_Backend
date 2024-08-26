package v0.project.mysite.work.HJH.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import v0.project.mysite.work.HJH.mapper.ImageMapper;
import v0.project.mysite.work.HJH.mapper.MembersMapper;
import v0.project.mysite.work.HJH.model.Image;
import v0.project.mysite.work.HJH.model.Members;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MembersService {

    private final MembersMapper membersMapper;

    public Members selectById(int id) {
        return membersMapper.selectById(id);
    }

    public List<Members> selectAll() {
        return membersMapper.selectAll();
    }

    public void insert(Members members) {
        membersMapper.insert(members);
    }

    public void update(Members member) {
        membersMapper.update(member);
    }

    public void delete(int id) {
        membersMapper.delete(id);
    }
}
