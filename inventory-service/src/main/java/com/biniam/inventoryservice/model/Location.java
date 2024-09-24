package com.biniam.inventoryservice.model;

import com.biniam.inventoryservice.dto.Address;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Location {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long location_id;
    @Embedded
    private Address address;
}
