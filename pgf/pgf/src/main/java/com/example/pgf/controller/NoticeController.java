package com.example.pgf.controller;

import com.example.pgf.dto.NoticeDto;
import com.example.pgf.service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/notices")
public class NoticeController {

    @Autowired
    private NoticeService noticeService;

    @PostMapping
    public NoticeDto saveNotice(@RequestBody NoticeDto noticeDto) {
        return noticeService.saveNotice(noticeDto);
    }

    @GetMapping
    public List<NoticeDto> getAllNotices() {
        return noticeService.getAllNotices();
    }

    @GetMapping("/{id}")
    public NoticeDto getNotice(@PathVariable Long id) {
        return noticeService.getNoticeById(id);
    }

    @PutMapping("/{id}")
    public NoticeDto updateNotice(@PathVariable Long id,
                                  @RequestBody NoticeDto noticeDto) {
        return noticeService.updateNotice(id, noticeDto);
    }

    @DeleteMapping("/{id}")
    public String deleteNotice(@PathVariable Long id) {
        noticeService.deleteNotice(id);
        return "Notice Deleted Successfully";
    }
}