package org.example.service.dto.customerDto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CustomerSaveRequest {


    @NotNull(message = "first name must not be null")
    @NotBlank(message = "first name must not be blank")
    private String firstname;
    @NotNull(message = "last name must not be null")
    @NotBlank(message = "last name must not be blank")
    private String lastname;
    @NotNull(message = "email must not be null")
    @NotBlank(message = "email must not be blank")
    private String email;
    @NotNull(message = "password must not be null")
    @NotBlank(message = "password must not be blank")
    private String password;

}
