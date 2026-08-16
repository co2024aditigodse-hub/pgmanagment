package com.example.pgf.service.service.impl;

import com.example.pgf.dto.ComplaintDto;
import com.example.pgf.entity.Complaint;
import com.example.pgf.entity.User;
import com.example.pgf.repository.ComplaintRepository;
import com.example.pgf.repository.UserRepository;
import com.example.pgf.service.ComplaintService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ComplaintServiceImpl implements ComplaintService {

    @Autowired
    private ComplaintRepository complaintRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public ComplaintDto saveComplaint(ComplaintDto complaintDto) {

        User user = userRepository.findById(complaintDto.getUserId())
                .orElseThrow(() -> new RuntimeException("User Not Found"));

        Complaint complaint = new Complaint();

        complaint.setSubject(complaintDto.getSubject());
        complaint.setDescription(complaintDto.getDescription());
        complaint.setStatus(complaintDto.getStatus());
        complaint.setComplaintDate(complaintDto.getComplaintDate());
        complaint.setUser(user);

        return convertToDto(complaintRepository.save(complaint));
    }

    @Override
    public ComplaintDto updateComplaint(Long id, ComplaintDto complaintDto) {

        Complaint complaint = complaintRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Complaint Not Found"));

        complaint.setSubject(complaintDto.getSubject());
        complaint.setDescription(complaintDto.getDescription());
        complaint.setStatus(complaintDto.getStatus());

        return convertToDto(complaintRepository.save(complaint));
    }

    @Override
    public ComplaintDto getComplaintById(Long id) {

        return convertToDto(complaintRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Complaint Not Found")));
    }

    @Override
    public List<ComplaintDto> getAllComplaints() {

        List<ComplaintDto> list = new ArrayList<>();

        for (Complaint complaint : complaintRepository.findAll()) {
            list.add(convertToDto(complaint));
        }

        return list;
    }

    @Override
    public void deleteComplaint(Long id) {
        complaintRepository.deleteById(id);
    }

    private ComplaintDto convertToDto(Complaint complaint) {

        ComplaintDto dto = new ComplaintDto();

        dto.setId(complaint.getId());
        dto.setSubject(complaint.getSubject());
        dto.setDescription(complaint.getDescription());
        dto.setStatus(complaint.getStatus());
        dto.setComplaintDate(complaint.getComplaintDate());

        if (complaint.getUser() != null) {
            dto.setUserId(complaint.getUser().getId());
        }

        return dto;
    }
}