package com.mertg.cinemia.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.validator.constraints.Email;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "addresses")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long addressId;

    @NotBlank
    @Size(min = 3, message = "Street name must be at least 3 characters")

    private String street;

    @Size(min = 3, message = "Building name must be at least 3 characters")
    private String buildingName;

    @NotBlank
    @Size(min = 3, message = "City name must be at least 3 characters")
    private String city;

    @NotBlank
    @Size(min = 3, message = "Country name must be at least 3 characters")
    private String country;

    @NotBlank
    @Size(min = 3, message = "Zipcode must be at least 3 characters")
    private String zipcode;

    @ToString.Exclude
    @ManyToMany(mappedBy = "addresses")
    private List<User> users = new ArrayList<>();
}
