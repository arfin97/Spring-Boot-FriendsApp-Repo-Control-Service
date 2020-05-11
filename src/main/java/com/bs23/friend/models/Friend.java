package com.bs23.friend.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

@Entity
public class Friend {
    @Id
    @GeneratedValue
    private Long id;
    @NotBlank
    private String name;
    private String email;
    private String phone;
    private boolean married;
    private Integer age;

    @JsonManagedReference
    @OneToMany(mappedBy = "friend", cascade = CascadeType.ALL)
    private List<Address> addressList;


}

