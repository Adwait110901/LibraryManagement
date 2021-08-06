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
public class Book {
    @Id

    @Column
    private  String bookName;

    @Column
    private String author;

    @Column
    private String subject;

    @Column
    private int bookID;

}
