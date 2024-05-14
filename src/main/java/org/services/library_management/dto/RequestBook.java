package org.services.library_management.dto;


import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class RequestBook {

    private Long id;

    @NotNull
    @Size(min = 5,message = "Title is to be at least 5 characters")
    private String tittle;
    @NotNull
    @Size(min = 2,message = "Author is to be at least 2 characters")
    private String author;
    @NotNull

    private Long publicationYear;
    @NotNull
    @Size(min = 2,message = "ISBN is to be at least 2 characters")
    private String isbn;

}
