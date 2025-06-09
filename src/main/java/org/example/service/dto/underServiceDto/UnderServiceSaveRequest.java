package org.example.service.dto.underServiceDto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class UnderServiceSaveRequest {


    @NotNull(message = "name must not be null")
    @NotBlank(message = "name must not be blank")
    private String name  ;

    @NotNull(message = "basePrice must not be null")
    private BigDecimal basePrice;

    @NotNull(message = "description must not be null")
    @NotBlank(message = "description must not be blank")
    private String description;



}
