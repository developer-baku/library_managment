package org.services.library_management.dto;



import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.services.library_management.entities.Records;

import java.util.List;

@AllArgsConstructor
@Getter
public class RequestPatron {

    private Long id;
    @NotNull
    @Size(min = 2,message = "Name is to be at least 2 characters")
    private String name;
    @NotNull
    @Size(min = 4,message = "Contact is to be at least 4 characters")
    private String contact;

}
