package org.example.expert.domain.todo.dto.request;

import lombok.Getter;

import java.time.LocalDate;

@Getter
public class TodoSearchRequest {
    private String keyword;
    private LocalDate startDate;
    private LocalDate endDate;
    private String assigneeNickname;
    public TodoSearchRequest(String keyword, LocalDate startDate, LocalDate endDate, String assigneeNickname) {
        this.keyword = keyword;
        this.startDate = startDate;
        this.endDate = endDate;
        this.assigneeNickname = assigneeNickname;
    }
}