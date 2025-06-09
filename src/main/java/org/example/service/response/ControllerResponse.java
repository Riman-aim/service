package org.example.service.response;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;


@Getter
@Setter
public class ControllerResponse {

    private String message;
    private LocalDate localDate;

    public ControllerResponse(String message , LocalDate localDate) {
        this.message = message;
        this.localDate = localDate;
    }
}
