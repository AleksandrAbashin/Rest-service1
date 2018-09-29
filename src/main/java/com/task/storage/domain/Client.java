package com.task.storage.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Table(name = "client")
public class Client {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column
    private Long id;
    private String name;

   @OneToMany(mappedBy = "client",
            fetch = FetchType.LAZY,
            cascade = CascadeType.ALL
    )
    protected List<Application> applications;
}
