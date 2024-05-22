package com.store.Store.model;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@Entity
@Table(name = "Addresses")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int number;
    private String street;
    private String postcode;

    @ManyToOne
    @JoinColumn(name = "city_id", nullable = false)
    private City city;


    //@Column(name = "fullname")
    //private String fullname;
}
