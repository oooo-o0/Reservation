package com.example.app.domain;

import java.time.LocalDate;
import java.util.List;

import org.hibernate.validator.constraints.Range;
import org.springframework.format.annotation.DateTimeFormat;

import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class BookingFormItem {
    @NotBlank
    @Size(max = 10)
    private String name;
    @NotBlank
    @Email
    private String email;
    @NotNull
    @Range(min = 1, max = 10)
    private Integer number;
    private RoomType roomType;
    @Future
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate date;
    @NotEmpty
    private List<Integer> time;
    private Integer parking;
    @AssertTrue
    private Boolean agreement;
}
