package org.services.library_management.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Table(name = "borrowing_record")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class Records {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date whenBorrowed;
    private Date whenReturned;
    @ManyToOne
    private Book book;
    @ManyToOne
    private Patron patron;



}
