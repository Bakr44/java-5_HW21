package com.example.assignment21.DTO;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AddressDTO {
    private Integer teacher_id;

    @NotEmpty
    private String area;

    @NotEmpty
    private String street;

    @NotEmpty
    private String buildingNumber;
}
