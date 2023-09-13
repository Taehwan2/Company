package com.example.eco.rich.regions.db;

import com.example.eco.rich.countries.db.Country;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "regions")
@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Region {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "region_id",nullable = false,unique = true)
    private Integer regionId;

    @Column(name = "region_Name")
    private String regionName = null;

    @OneToMany(mappedBy = "region")
    private List<Country> countries;
}
