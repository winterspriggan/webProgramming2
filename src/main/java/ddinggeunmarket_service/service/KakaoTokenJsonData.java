package ddinggeunmarket_service.service;

import ddinggeunmarket_service.jpa.user.kakao.KakaoTokenResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

@Component
@RequiredArgsConstructor
public class KakaoTokenJsonData {
    private final WebClient webClient;
    private static final String ACCESS_TOKEN_URI = "https://kauth.kakao.com/oauth/token";
    private static final String LOGOUT_URI = "https://kauth.kakao.com/oauth/logout";
    private static final String REDIRECT_URI = "http://localhost:40040/kakao/login";
    private static final String REDIRECT_LOGOUT_URI = "http://localhost:40040/kakao/logout";
    private static final String GRANT_TYPE = "authorization_code";
    private static final String CLIENT_ID = "092b8dd8c678497e53440f488cc95702";

    public KakaoTokenResponse getToken(String code) {
        String uri = ACCESS_TOKEN_URI + "?grant_type=" + GRANT_TYPE + "&client_id=" + CLIENT_ID + "&redirect_uri=" + REDIRECT_URI + "&code=" + code;
        System.out.println(uri);

        Flux<KakaoTokenResponse> response = webClient.post()
                .uri(uri)
                .contentType(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToFlux(KakaoTokenResponse.class);

        return response.blockFirst();
    }
    public String logout() {
        String uri = LOGOUT_URI+"?client_id="+CLIENT_ID+"&logout_redirect_uri="+REDIRECT_LOGOUT_URI;
        System.out.println(uri);
        Flux<String> response = webClient.get()
                .uri(uri)
                .retrieve()
                .bodyToFlux(String.class);

        return response.blockFirst();
    }
}