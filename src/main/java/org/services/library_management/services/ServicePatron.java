package org.services.library_management.services;

import lombok.AllArgsConstructor;
import org.services.library_management.dto.RequestPatron;
import org.services.library_management.dto.ResponsePatron;
import org.services.library_management.entities.Patron;
import org.services.library_management.repository.RepositoryPatron;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ServicePatron {
    private final RepositoryPatron repositoryPatron;

    public void deletePatron(Long id) throws Exception {
        if (repositoryPatron.existsById(id)) repositoryPatron.deleteById(id);
        else throw new Exception();


    }

    public List<ResponsePatron> getPatrons() {
        return repositoryPatron.findAll().stream().map(f->ResponsePatron.builder()
                .contact(f.getContact())
                .name(f.getName())
                .id(f.getId())
                .build()).toList();
    }
    public void addPatron(RequestPatron requestPatron) {
        repositoryPatron.save(Patron.builder()
                        .name(requestPatron.getName())
                        .contact(requestPatron.getContact())

                .build());

    }
    public ResponsePatron getPatronById(Long id) throws Exception {
        if (repositoryPatron.existsById(id)){
            var patron = repositoryPatron.findById(id).get();

            return ResponsePatron.builder()

                            .contact(patron.getContact())
                            .name(patron.getName())
                            .id(patron.getId())

                    .build();
        }
        else throw new Exception();
    }

    public void updatePatron(Long id,RequestPatron requestPatron) throws Exception{
       if (repositoryPatron.existsById(id)) repositoryPatron.save(
               Patron.builder()

                       .name(requestPatron.getName())

                       .contact(requestPatron.getContact())
                       .id(id)
                       .build()
       );
        else throw new Exception();
    }
}
