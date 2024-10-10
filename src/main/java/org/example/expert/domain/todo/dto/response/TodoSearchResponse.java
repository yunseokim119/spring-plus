package org.example.expert.domain.todo.dto.response;

import com.querydsl.core.annotations.QueryProjection;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
public class TodoSearchResponse {
    private Long id;
    private String title;
    private int managerCount;
    private int commentCount;
    private LocalDateTime createAt;
    @QueryProjection
    public TodoSearchResponse(Long id, String title, int managerCount, int commentCount, LocalDateTime createAt) {
        this.id = id;
        this.title = title;
        this.managerCount = managerCount;
        this.commentCount = commentCount;
        this.createAt = createAt;
    }
}