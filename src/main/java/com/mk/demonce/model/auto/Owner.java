package com.mk.demonce.model.auto;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
@Entity
@Getter
@Setter
public class Owner {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
private String name;
    @OneToMany(mappedBy = "owner")
    private List<car> cars=new ArrayList<>();
}
