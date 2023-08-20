package com.example.assignment21.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty
    private String area;

    @NotEmpty
    private String street;

    @NotEmpty
    private String buildingNumber;

    @OneToOne(cascade = CascadeType.DETACH)
    @MapsId
    @JsonIgnore
    private Teacher teacher;
}
