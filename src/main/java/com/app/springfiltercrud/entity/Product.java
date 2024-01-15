package com.app.springfiltercrud.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "product")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(nullable = false, length = 60)
    @NotBlank(message = "Please type the name")
    String name;

    @Column(nullable = false, length = 60)
    @NotBlank(message = "Please type the brand")
    String brand;

    @Column(nullable = false, length = 60)
    @NotBlank(message = "Please type the madein")
    String madeIn;

    @Column(nullable = false, columnDefinition = "int")
    @NotNull
    @Digits(integer = 10, fraction = 2, message = "Invalid price format")
    int price;


}
