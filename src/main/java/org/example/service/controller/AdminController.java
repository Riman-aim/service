package org.example.service.controller;


import jakarta.validation.Valid;
import org.example.service.dto.serviceDto.GetAllResponse;
import org.example.service.dto.serviceDto.ServiceSaveRequest;
import org.example.service.dto.underServiceDto.UnderServiceSaveRequest;
import org.example.service.response.ControllerResponse;
import org.example.service.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.management.ServiceNotFoundException;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/adminManaging")
public class AdminController {

    private AdminService adminService;

    @Autowired
    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }


    @PostMapping("/newService/{adminId}")
    public ControllerResponse addNewService
            (@PathVariable int adminId , @Valid @RequestBody ServiceSaveRequest serviceSaveRequest) {
        adminService.addNewService(adminId, serviceSaveRequest);
        return new ControllerResponse("added successfully " , LocalDate.now());
    }

    @PostMapping("newUnderService/{adminId}/{serviceId}")
    public ControllerResponse addNewUnderService
            (@PathVariable int adminId ,@PathVariable int serviceId, @Valid @RequestBody UnderServiceSaveRequest underServiceSaveRequest) {
        adminService.addNewUnderService(adminId, serviceId,underServiceSaveRequest);
        return new ControllerResponse("added successfully " , LocalDate.now());
    }

    @GetMapping("/getAllServices/{adminId}")
    public List<GetAllResponse> getAllServices(@PathVariable int adminId) {
        return adminService.getAllServices(adminId);
    }

}
