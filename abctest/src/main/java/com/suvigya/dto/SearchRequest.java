package com.suvigya.dto;

import java.time.LocalDate;

public class SearchRequest {
    private String memberName;
    private LocalDate startDate;
    private LocalDate endDate;

    // Default constructor
    public SearchRequest() {}

    // Constructor with fields
    public SearchRequest(String memberName, LocalDate startDate, LocalDate endDate) {
        this.memberName = memberName;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    // Getters and setters
    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }
}

