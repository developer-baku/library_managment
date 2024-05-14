package org.services.library_management.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Setter
@Getter
public class ResponsePatron {
    private Long id;
    private String name;
    private String contact;
}
