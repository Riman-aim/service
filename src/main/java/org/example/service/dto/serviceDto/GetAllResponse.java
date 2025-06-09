package org.example.service.dto.serviceDto;


import lombok.Getter;
import lombok.Setter;
import org.example.service.domain.UnderService;

import java.util.List;

@Getter
@Setter
public class GetAllResponse {

    private String name ;

    private String description;

    List<UnderService> underServices ;
}
