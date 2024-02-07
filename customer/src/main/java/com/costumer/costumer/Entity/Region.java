package com.costumer.costumer.Entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "regions")
@Data
public class Region {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
}
