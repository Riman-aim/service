package org.example.service.service;

import org.example.service.convertor.Convertor;
import org.example.service.domain.UnderService;
import org.example.service.dto.underServiceDto.UnderServiceSaveRequest;
import org.example.service.exception.UnderServiceNameDuplicated;
import org.example.service.repository.UnderServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.management.ServiceNotFoundException;

@Service
public class UnderServiceService {


    private final UnderServiceRepository underServiceRepository;

    private final Convertor convertor;

    private final ServiceService serviceService;


    @Autowired
    public UnderServiceService(UnderServiceRepository underServiceRepository, Convertor convertor , ServiceService serviceService) {
        this.underServiceRepository = underServiceRepository;
        this.convertor = convertor;
        this.serviceService = serviceService;
    }

    public void save(int serviceId,UnderServiceSaveRequest underServiceSaveRequest)  {
        if(!underServiceRepository.existsByName(underServiceSaveRequest.getName())) {
            UnderService underService = convertor.
                    underServiceSaveRequestToUnderService(underServiceSaveRequest);
            underService.setService(serviceService.findById(serviceId));
            underServiceRepository.save(underService);


        }
        else {
            throw new UnderServiceNameDuplicated("Under Service Name already exists");
        }
    }

    public boolean existsByName(String name){
        return underServiceRepository.existsByName(name);
    }
}
