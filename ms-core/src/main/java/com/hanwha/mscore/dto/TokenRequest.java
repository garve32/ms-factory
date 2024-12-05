package com.hanwha.mscore.dto;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class TokenRequest {

    private String userId;
    private String password;

}
