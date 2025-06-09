package org.example.service.convertor;
import org.example.service.domain.Customer;
import org.example.service.domain.Service;
import org.example.service.domain.UnderService;
import org.example.service.dto.customerDto.CustomerSaveRequest;
import org.example.service.dto.serviceDto.GetAllResponse;
import org.example.service.dto.serviceDto.ServiceSaveRequest;
import org.example.service.dto.underServiceDto.UnderServiceSaveRequest;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Convertor {


    private ModelMapper modelMapper ;

    public Convertor() {
        modelMapper = new ModelMapper();
    }

    public Service serviceSaveRequestToService(ServiceSaveRequest serviceSaveRequest) {
         return modelMapper.map(serviceSaveRequest, Service.class);
    }

    public UnderService underServiceSaveRequestToUnderService(UnderServiceSaveRequest underServiceSaveRequest) {
        return modelMapper.map(underServiceSaveRequest, UnderService.class);
    }

    public GetAllResponse serviceToGetAllResponse(Service service) {
        return  modelMapper.map(service, GetAllResponse.class);
    }

    public Customer customerSaveRequestToCustomer(CustomerSaveRequest customerSaveRequest) {
        return modelMapper.map(customerSaveRequest, Customer.class);
    }


}
