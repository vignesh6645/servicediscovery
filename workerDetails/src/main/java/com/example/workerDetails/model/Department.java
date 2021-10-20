package com.example.workerDetails.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@Table(name = "Dept")
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "dept_Id")
    private Integer Id;

    @Column(name = "dept_name")
    private String dept_name;

    @Column(name = "dept_members")
    private Integer dept_members;


    @ManyToOne(cascade =CascadeType.ALL)
    @JoinColumn(name = "worker_id")
    private worker Worker;
}
