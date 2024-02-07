package com.costumer.costumer.Entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Entity
@Table(name = "customers")
@Data
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "The number id must not be empty")
    @Size(min = 8, max = 8, message = "The size of the number id has to be 8")
    @Column(name = "number_id", unique = true, length = 8, nullable = false)
    private String numberID;

    @NotEmpty(message = "The name can not be empty")
    @Column(name = "first_name", nullable = false)
    private String firstName;

    @NotEmpty(message = "The last name can not be empty")
    @Column(name = "last_name", nullable = false)
    private String lastName;

    @NotEmpty(message = "The email can not be empty")
    @Email(message = "This in not a valid email format")
    @Column(unique = true, nullable = false)
    private String email;

    @Column(name = "photo_url")
    private String photoUrl;

    @NotNull(message = "The region can not be empty")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "region_id")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Region region;

    private String state;

}
