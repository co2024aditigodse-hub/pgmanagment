package com.example.pgf.service;

import com.example.pgf.dto.ComplaintDto;

import java.util.List;

public interface ComplaintService {

    ComplaintDto saveComplaint(ComplaintDto complaintDto);

    ComplaintDto updateComplaint(Long id, ComplaintDto complaintDto);

    ComplaintDto getComplaintById(Long id);

    List<ComplaintDto> getAllComplaints();

    void deleteComplaint(Long id);

}