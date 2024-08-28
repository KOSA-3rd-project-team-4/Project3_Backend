package v0.project.mysite.PJH;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;
import v0.project.mysite.work.HJH.mapper.MembersMapper;
import v0.project.mysite.work.HJH.model.Members;

@Service
@Slf4j
@RequiredArgsConstructor
public class CustomOAuth2UserService extends DefaultOAuth2UserService {

    private final MembersMapper membersMapper;

    @Override
    public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
        OAuth2User oAuth2User = super.loadUser(userRequest);
        log.info("oAuth2User Attributes: {}", oAuth2User.getAttributes());

        String registrationId = userRequest.getClientRegistration().getRegistrationId();
        OAuth2Response oAuth2Response;
        if ("naver".equals(registrationId)) {
            oAuth2Response = new NaverResponse(oAuth2User.getAttributes());
        } else {
            throw new OAuth2AuthenticationException("Unsupported OAuth2 provider");
        }

        Members existingMember = membersMapper.selectByUsername(oAuth2Response.getName());

        String role = "ROLE_USER";
        if (existingMember == null) {
            Members newMember = new Members();
            newMember.setNick_name(oAuth2Response.getName());
            newMember.setEmail(oAuth2Response.getEmail());
            newMember.setPassword("");  // OAuth2 로그인의 경우 비밀번호가 필요 없을 수 있습니다.
            membersMapper.insert(newMember);
        } else {
            existingMember.setEmail(oAuth2Response.getEmail());
            existingMember.setNick_name(oAuth2Response.getName());
            membersMapper.update(existingMember);
        }

        // OAuth2User 생성
        CustomOAuth2User customOAuth2User = new CustomOAuth2User(oAuth2Response, role);

        // 로그 추가: SecurityContextHolder에 저장된 인증 정보 확인


        return new CustomOAuth2User(oAuth2Response, role);
    }
}