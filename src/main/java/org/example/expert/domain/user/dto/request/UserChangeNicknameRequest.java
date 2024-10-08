package org.example.expert.domain.user.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class UserChangeNicknameRequest {
    private String newNickname;
}