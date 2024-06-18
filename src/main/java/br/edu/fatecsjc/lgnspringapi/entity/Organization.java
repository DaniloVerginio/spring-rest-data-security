package br.edu.fatecsjc.lgnspringapi.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Collection;
import java.util.List;


@Getter
@Setter
@Entity
@Table(name = "organization")
public class Organization {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Embedded
    private Address address;

    @Column(name = "institution_name")
    private String institutionName;

    @Column(name = "headquarters_country")
    private String headquartersCountry;



}



