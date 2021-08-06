package com.example.library_management.Model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table
public class User {
    @Id
    @Column
    private  int id;
    @Column

    private  String name;
    @Column
    private String email;

}
