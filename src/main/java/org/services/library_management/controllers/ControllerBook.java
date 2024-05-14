package org.services.library_management.controllers;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.services.library_management.dto.RequestBook;
import org.services.library_management.dto.ResponseBook;
import org.services.library_management.services.ServiceBook;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/books")
@AllArgsConstructor
public class ControllerBook {
    private final ServiceBook serviceBook;
    @GetMapping
    public ResponseEntity<List<ResponseBook>> getBooks() {
        return new ResponseEntity<>(serviceBook.getBooks(),HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseBook> getBookById(@PathVariable Long id) {
       try {
           return new ResponseEntity<>(serviceBook.getBookById(id),HttpStatus.FOUND);
       }
       catch (Exception runtimeException){
           throw new ResponseStatusException(HttpStatus.NOT_FOUND,"book with provided id does not exist",runtimeException);
       }
    }
    @PostMapping()
    public ResponseEntity<String> addBook(@Valid @RequestBody RequestBook requestBook) {

        serviceBook.addBook(requestBook);
        return new ResponseEntity<>("book added",HttpStatus.CREATED);
    }
    @PutMapping("/{id}")
    public ResponseEntity<String> updateBook(@Valid @PathVariable Long id, @RequestBody RequestBook requestBook) {
       try {
           serviceBook.updateBook(id,requestBook);
           return new ResponseEntity<>("book updated",HttpStatus.OK);

       }catch (Exception e) {
           throw new ResponseStatusException(HttpStatus.NOT_FOUND,"book with provided id does not exist",e);

       }

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteBook(@PathVariable Long id) {
        try {
            serviceBook.deleteBook(id);
            return new ResponseEntity<>("book deleted",HttpStatus.OK) ;

        }catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"book with provided id does not exist",e);

        }

    }


}
