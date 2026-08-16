package com.example.pgf.service.service.impl;

import com.example.pgf.dto.NoticeDto;
import com.example.pgf.entity.Notice;
import com.example.pgf.repository.NoticeRepository;
import com.example.pgf.service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class NoticeServiceImpl implements NoticeService {

    @Autowired
    private NoticeRepository noticeRepository;

    @Override
    public NoticeDto saveNotice(NoticeDto noticeDto) {

        Notice notice = new Notice();

        notice.setTitle(noticeDto.getTitle());
        notice.setMessage(noticeDto.getMessage());
        notice.setNoticeDate(noticeDto.getNoticeDate());

        return convertToDto(noticeRepository.save(notice));
    }

    @Override
    public NoticeDto updateNotice(Long id, NoticeDto noticeDto) {

        Notice notice = noticeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Notice Not Found"));

        notice.setTitle(noticeDto.getTitle());
        notice.setMessage(noticeDto.getMessage());

        return convertToDto(noticeRepository.save(notice));
    }

    @Override
    public NoticeDto getNoticeById(Long id) {

        return convertToDto(noticeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Notice Not Found")));
    }

    @Override
    public List<NoticeDto> getAllNotices() {

        List<NoticeDto> list = new ArrayList<>();

        for (Notice notice : noticeRepository.findAll()) {
            list.add(convertToDto(notice));
        }

        return list;
    }

    @Override
    public void deleteNotice(Long id) {
        noticeRepository.deleteById(id);
    }

    private NoticeDto convertToDto(Notice notice) {

        NoticeDto dto = new NoticeDto();

        dto.setId(notice.getId());
        dto.setTitle(notice.getTitle());
        dto.setMessage(notice.getMessage());
        dto.setNoticeDate(notice.getNoticeDate());

        return dto;
    }
}