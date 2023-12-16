package ddinggeunmarket_service.controller;

import ddinggeunmarket_service.jpa.user.kakao.KakaoTokenResponse;
import ddinggeunmarket_service.jpa.user.kakao.KakaoUserInfo;
import ddinggeunmarket_service.jpa.user.kakao.KakaoUserInfoResponse;
import ddinggeunmarket_service.service.KakaoTokenJsonData;
import ddinggeunmarket_service.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins ="http://localhost:40040")
@RestController
@RequiredArgsConstructor
public class KakaoLoginController {

    private final KakaoUserInfo kakaoUserInfo;
    private final KakaoTokenJsonData kakaoTokenJsonData;
    private final UserService userService;

    private static final String CLIENT_ID = "092b8dd8c678497e53440f488cc95702";
    private static final String CLIENT_SECRET = "9K7QPE8Dfvu9MfHMHIOolokg24hYydwi";
    private static final String REDIRECT_URI = "http://localhost:40040/kakao/login";


    @GetMapping("/kakao/login")
    public String getAccessToken(@RequestParam("code") String code) {
        System.out.println("인가 코드 ->  엑세스 토큰");
        KakaoTokenResponse kakaoTokenResponse = kakaoTokenJsonData.getToken(code);
        System.out.println("토큰 : "+ kakaoTokenResponse);
        KakaoUserInfoResponse userInfo = kakaoUserInfo.getUserInfo(kakaoTokenResponse.getAccess_token());
        System.out.println("회원 정보 : " + userInfo);
        userService.accessByKakao(userInfo.getKakao_account().getEmail() , userInfo.getKakao_account().getNickname());
        return "good";
    }

}
