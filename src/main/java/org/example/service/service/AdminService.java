package org.example.service.service;

import org.example.service.convertor.Convertor;
import org.example.service.dto.serviceDto.GetAllResponse;
import org.example.service.dto.serviceDto.ServiceSaveRequest;
import org.example.service.dto.underServiceDto.UnderServiceSaveRequest;
import org.example.service.exception.AdminNotFoundException;
import org.example.service.exception.ServiceNotExistException;
import org.example.service.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class AdminService {

    private final AdminRepository adminRepository;

    private final ServiceService serviceService;

    private final UnderServiceService underServiceService;

    private final Convertor convertor;

    @Autowired
    public AdminService(AdminRepository adminRepository, Convertor convertor, ServiceService serviceService, UnderServiceService underServiceService) {
        this.adminRepository = adminRepository;
        this.serviceService = serviceService;
        this.underServiceService = underServiceService;
        this.convertor = convertor;
    }

    public void addNewService(int adminId, ServiceSaveRequest serviceSaveRequest) {
        if (adminRepository.existsById(adminId)) {
            serviceService.save(adminId, serviceSaveRequest);
        } else {
            throw new AdminNotFoundException("the admin by id: " + adminId + " does not exist");
        }
    }

    public void addNewUnderService(int adminId, int serviceId, UnderServiceSaveRequest underServiceSaveRequest) {

        if (!adminRepository.existsById(adminId)) {
            throw new AdminNotFoundException
                    ("the admin by id: " + adminId + " does not exist");
        } else if (!serviceService.existsServiceById(serviceId)) {
            throw new ServiceNotExistException
                    ("the service by id: " + serviceId + " does not exist");
        } else if (underServiceService.existsByName(underServiceSaveRequest.getName())) {
            throw new AdminNotFoundException
                    ("the admin by id: " + adminId + " does not exist");
        } else {
            underServiceService.save(serviceId, underServiceSaveRequest);
        }
    }

    public List<GetAllResponse> getAllServices(int adminId) {
        if (adminRepository.existsById(adminId)) {
            return serviceService.getAllServices();

        } else {
            throw new AdminNotFoundException("the admin does not exist by id " + adminId);
        }
    }
}
