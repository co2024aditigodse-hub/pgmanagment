package com.example.pgf.service;

import com.example.pgf.dto.NoticeDto;

import java.util.List;

public interface NoticeService {

    NoticeDto saveNotice(NoticeDto noticeDto);

    NoticeDto updateNotice(Long id, NoticeDto noticeDto);

    NoticeDto getNoticeById(Long id);

    List<NoticeDto> getAllNotices();

    void deleteNotice(Long id);

}