package org.example.expert.domain.todo.dto.request;

import lombok.Getter;

import java.time.LocalDate;

@Getter
public class TodoSearchRequest {
    private String keyword;
    private LocalDate startDate;
    private LocalDate endDate;
    private String assignedNickname;
    public TodoSearchRequest(String keyword, LocalDate startDate, LocalDate endDate, String assignedNickname) {
        this.keyword = keyword;
        this.startDate = startDate;
        this.endDate = endDate;
        this.assignedNickname = assignedNickname;
    }
}