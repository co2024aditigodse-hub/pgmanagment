package com.example.pgf.dto;

import java.time.LocalDate;

public class NoticeDto {

    private Long id;
    private String title;
    private String message;
    private LocalDate noticeDate;

    public NoticeDto() {
    }

    public NoticeDto(Long id, String title, String message,
                     LocalDate noticeDate) {
        this.id = id;
        this.title = title;
        this.message = message;
        this.noticeDate = noticeDate;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getMessage() {
        return message;
    }

    public LocalDate getNoticeDate() {
        return noticeDate;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setNoticeDate(LocalDate noticeDate) {
        this.noticeDate = noticeDate;
    }
}