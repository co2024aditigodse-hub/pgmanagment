package com.example.pgf.controller;

import com.example.pgf.dto.ComplaintDto;
import com.example.pgf.service.ComplaintService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/complaints")
public class ComplaintController {

    @Autowired
    private ComplaintService complaintService;

    @PostMapping
    public ComplaintDto saveComplaint(@RequestBody ComplaintDto complaintDto) {
        return complaintService.saveComplaint(complaintDto);
    }

    @GetMapping
    public List<ComplaintDto> getAllComplaints() {
        return complaintService.getAllComplaints();
    }

    @GetMapping("/{id}")
    public ComplaintDto getComplaint(@PathVariable Long id) {
        return complaintService.getComplaintById(id);
    }

    @PutMapping("/{id}")
    public ComplaintDto updateComplaint(@PathVariable Long id,
                                        @RequestBody ComplaintDto complaintDto) {
        return complaintService.updateComplaint(id, complaintDto);
    }

    @DeleteMapping("/{id}")
    public String deleteComplaint(@PathVariable Long id) {
        complaintService.deleteComplaint(id);
        return "Complaint Deleted Successfully";
    }
}