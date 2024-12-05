package com.hanwha.msauth.controller;

import com.hanwha.mscore.dto.TokenRequest;
import com.hanwha.mscore.dto.TokenResponse;
import java.util.HashMap;
import java.util.Map;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    @PostMapping("token")
    public TokenResponse getToken(@RequestBody TokenRequest tokenRequest) {
        log.info("token request: {}", tokenRequest);

        try {
            Thread.sleep(2000);
        } catch (InterruptedException ex) {
            throw new RuntimeException(ex);
        }

        log.info("token request: {}", tokenRequest);

        // todo : 사용자 조회 후 테넌트 ID를 가져와야 함.
        String accessToken = "test123";
        return TokenResponse.builder()
            .accessToken(accessToken)
            .build();
    }

    @GetMapping("/b")
    public Map b() {
        Map<String, Object> map = new HashMap();
        map.put("a", "b");
        return map;
    }
}
