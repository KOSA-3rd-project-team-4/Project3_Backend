package v0.project.mysite.KBC.service;

import org.springframework.security.core.Authentication;
import v0.project.mysite.work.HJH.model.BizMembers;

public interface IUserService {
   BizMembers getBizMembers(Authentication authentication);
}
