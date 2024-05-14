package org.services.library_management.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Table(name = "book")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String tittle;

    private String author;

    private Boolean available;

    @Column(name ="publication_year" )
    private Long publicationYear;

    @Column(name = "isbn")
    private String isbn;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "book")
    private List<Records> records;
}
