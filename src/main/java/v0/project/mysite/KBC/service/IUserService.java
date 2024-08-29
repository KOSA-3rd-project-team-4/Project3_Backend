package v0.project.mysite.KBC.service;

import org.springframework.security.core.Authentication;
import v0.project.mysite.KBC.DTO.TestBiz;
import v0.project.mysite.work.HJH.model.BizMembers;
import v0.project.mysite.work.HJH.model.Members;

import java.util.List;

public interface IUserService {
   BizMembers getBizMembers(Authentication authentication);

}
