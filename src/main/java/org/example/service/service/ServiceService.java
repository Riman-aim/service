package org.example.service.service;

import org.example.service.convertor.Convertor;
import org.example.service.dto.serviceDto.GetAllResponse;
import org.example.service.dto.serviceDto.ServiceSaveRequest;
import org.example.service.exception.ServiceNameIsDuplicatedException;
import org.example.service.exception.ServiceNotExistException;
import org.example.service.repository.ServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.management.ServiceNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ServiceService {

    private ServiceRepository serviceRepository;

    private Convertor serviceConvertor;


    @Autowired
    public ServiceService(ServiceRepository serviceRepository, Convertor serviceConvertor) {
        this.serviceRepository = serviceRepository;
        this.serviceConvertor = serviceConvertor;

    }

    public void save(int adminId, ServiceSaveRequest serviceSaveRequest) {
        if (!serviceRepository.existsServiceByName(serviceSaveRequest.getName())) {
            org.example.service.domain.Service service = serviceConvertor.
                    serviceSaveRequestToService(serviceSaveRequest);
            serviceRepository.save(service);
        } else {
            throw new ServiceNameIsDuplicatedException(
                    "the service by name: " + serviceSaveRequest.getName() + " already exists");
        }

    }

    public org.example.service.domain.Service findById(int id)  {
        return serviceRepository.findById(id).
                orElseThrow(()-> new ServiceNotExistException("the service by id: " + id + " does not exist"));
    }

    public List<org.example.service.domain.Service> findAll() {
        return serviceRepository.findAll();
    }

    public boolean existsServiceById(int id) {
        return serviceRepository.existsById(id);
    }

    public List<GetAllResponse> getAllServices() {
        List<GetAllResponse> allResponses = new ArrayList<>();
        List<org.example.service.domain.Service> serviceList = this.findAll();
        serviceList.forEach(service -> {
            GetAllResponse getAllResponse = serviceConvertor.serviceToGetAllResponse(service);
            allResponses.add(getAllResponse);
        });
        return allResponses;
    }


}

