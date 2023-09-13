package com.example.eco.rich.locations.db;

import com.example.eco.rich.countries.db.Country;
import com.example.eco.rich.departments.db.Department;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "locations")
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Location {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "location_id",nullable = false)
    private Integer locationId;

    @Column(name = "street_address")
    private String streetAddress;

    @Column(name = "postal_code")
    private String postalCode;

    @Column(name = "city",nullable = false)
    private String city;

    @Column(name = "state_province")
    private String stateProvince;

    @ManyToOne()
    @JoinColumn(name = "countryId",nullable = false)
    private Country country;

    @OneToMany(mappedBy = "location")
    private List<Department> departments;
}
