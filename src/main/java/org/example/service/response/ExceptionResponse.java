package org.example.service.response;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;


@Getter
@Setter
public class ExceptionResponse {

    private String message;

    private LocalDate localDate;

    public ExceptionResponse(String message, LocalDate localDate) {
        this.message = message;
        this.localDate = localDate;
    }
}
