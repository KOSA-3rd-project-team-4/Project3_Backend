package v0.project.mysite.KBC.service;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import v0.project.mysite.KBC.repository.IUserRepository;
import v0.project.mysite.work.HJH.model.BizMembers;

@Service
@Log4j2
public class UserService implements IUserService {

    @Autowired
    @Qualifier("IUserRepository")
    IUserRepository userRepository;

    @Override
    public BizMembers getBizMembers(Authentication authentication) {
        Object principal = authentication.getPrincipal();
        String username = null;
        if (principal instanceof UserDetails) {
            UserDetails user = (UserDetails) principal;
            username = user.getUsername();
        }
        return userRepository.getBizMember(username);
    }

}
