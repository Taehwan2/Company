package com.example.eco.rich.countries.db;

import com.example.eco.rich.locations.db.Location;
import com.example.eco.rich.regions.db.Region;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "countries")
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Country {
    @Id
    @Column(name = "country_id",nullable = false,columnDefinition = "CHAR(2)")
    private String countryId;

    @Column(name = "country_name")
    private String countryName;

    @ManyToOne()
    @JoinColumn(name ="regionId")
    private Region region;

    @OneToMany(mappedBy = "country")
    private List<Location> locations;

}
