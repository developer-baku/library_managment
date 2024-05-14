package org.services.library_management.controllers;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.services.library_management.dto.RequestPatron;
import org.services.library_management.dto.ResponsePatron;
import org.services.library_management.services.ServicePatron;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/patrons")
public class ControllerPatron {
    private final ServicePatron servicePatron;
    @GetMapping
    public ResponseEntity<List<ResponsePatron>> getPatrons() {
        return new ResponseEntity<>(servicePatron.getPatrons(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponsePatron> getPatronById(@PathVariable Long id) {

        try {
            return new ResponseEntity<>(servicePatron.getPatronById(id),HttpStatus.FOUND);
        }catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"patron with provided id does not exist",e);
        }
    }
    @PostMapping
    public ResponseEntity<String> addPatron(@Valid @RequestBody RequestPatron requestPatron) {
        servicePatron.addPatron(requestPatron);
        return new ResponseEntity<>("patron added",HttpStatus.CREATED);
    }
    @PutMapping("/{id}")
    public ResponseEntity<String> updatePatron(@Valid @PathVariable Long id, @RequestBody RequestPatron requestPatron) {

        try {
            servicePatron.updatePatron(id,requestPatron);
            return new ResponseEntity<>("patron updated",HttpStatus.OK);
        }catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"patron with provided id does not exist",e);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePatron(@PathVariable Long id) {
        try {
            servicePatron.deletePatron(id);
            return new ResponseEntity<>("patron deleted",HttpStatus.OK);
        }catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"patron with provided id does not exist",e);
        }
    }
}
