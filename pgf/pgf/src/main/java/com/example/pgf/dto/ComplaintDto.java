package com.example.pgf.dto;

import java.time.LocalDate;

public class ComplaintDto {

    private Long id;
    private String subject;
    private String description;
    private String status;
    private LocalDate complaintDate;
    private Long userId;

    public ComplaintDto() {
    }

    public ComplaintDto(Long id, String subject, String description,
                        String status, LocalDate complaintDate,
                        Long userId) {
        this.id = id;
        this.subject = subject;
        this.description = description;
        this.status = status;
        this.complaintDate = complaintDate;
        this.userId = userId;
    }

    public Long getId() {
        return id;
    }

    public String getSubject() {
        return subject;
    }

    public String getDescription() {
        return description;
    }

    public String getStatus() {
        return status;
    }

    public LocalDate getComplaintDate() {
        return complaintDate;
    }

    public Long getUserId() {
        return userId;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setComplaintDate(LocalDate complaintDate) {
        this.complaintDate = complaintDate;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}