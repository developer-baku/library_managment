package org.services.library_management.dto;

import jakarta.persistence.Column;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class ResponseBook {

    private Long id;
    private String tittle;
    private String author;
    private Boolean available;
    private Long publicationYear;
    private String isbn;
}
