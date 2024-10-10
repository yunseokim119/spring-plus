package org.example.expert.domain.user.controller;

import lombok.RequiredArgsConstructor;
import org.example.expert.domain.common.annotation.Auth;
import org.example.expert.domain.common.dto.AuthUser;
import org.example.expert.domain.user.dto.request.UserChangeNicknameRequest;
import org.example.expert.domain.user.dto.request.UserChangePasswordRequest;
import org.example.expert.domain.user.dto.response.UserResponse;
import org.example.expert.domain.user.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @GetMapping("/{userId}")
    public ResponseEntity<UserResponse> getUser(@PathVariable long userId) {
        return ResponseEntity.ok(userService.getUser(userId));
    }

    @PutMapping
    public void changePassword(@AuthenticationPrincipal AuthUser authUser, @RequestBody UserChangePasswordRequest userChangePasswordRequest) {
        userService.changePassword(authUser.getId(), userChangePasswordRequest);
    }

    @PutMapping("/{userId}/nickname")
    public ResponseEntity<Void> updateNickname(@Auth AuthUser authUser, @PathVariable Long userId, @RequestBody UserChangeNicknameRequest userChangeNicknameRequest
    ) {
        // 요청한 사용자가 자신의 닉네임을 변경하는 경우 확인
        if (!authUser.getId().equals(userId)) {
            return ResponseEntity.status(403).build(); // 권한 없음
        }

        userService.changeNickname(userId, userChangeNicknameRequest);
        return ResponseEntity.ok().build();
    }
}