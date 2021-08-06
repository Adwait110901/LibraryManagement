package com.example.library_management.Model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Table
@Getter
@Setter
@Entity
public class IssuedBook {
    @Id
    @Column
    private int issuedBookId;

    @Column
    private String Status;


    @Column
    private int bookId;
    @Column
    private int userId;
}
