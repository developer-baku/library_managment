package org.services.library_management.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Table(name = "patron")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class Patron {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String contact;
    @OneToMany(fetch = FetchType.EAGER,mappedBy = "patron")
    private List<Records> records;
}
