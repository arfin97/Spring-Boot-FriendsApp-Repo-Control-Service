package com.bs23.friend.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString

@Entity
public class Address {
    @Id
    @GeneratedValue
    private Long id;
    private String city;
    private String area;

    @JsonBackReference
    @ManyToOne
    private Friend friend;

}
