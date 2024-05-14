package org.services.library_management.controllers;

import lombok.AllArgsConstructor;
import org.services.library_management.services.ServiceRecords;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class ControllerRecords {
    private  final ServiceRecords serviceRecords;

    @PostMapping(value = "/borrow/{bookId}/patron/{patronId}")
    public ResponseEntity<String> borrowIt(@PathVariable Long bookId, @PathVariable Long patronId) {
        try {
            serviceRecords.borrowIt(bookId,patronId);
            return new ResponseEntity<>("book borrowed",HttpStatus.OK);

        }catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,e.getMessage(),e);
        }
    }
    @PutMapping(value = "/return/{bookId}/patron/{patronId}")
    public ResponseEntity<String> returnIt(@PathVariable Long bookId, @PathVariable Long patronId) {
      try {
          serviceRecords.returnIt(bookId,patronId);
          return new ResponseEntity<>("book returned",HttpStatus.OK);

      }catch (Exception e) {
          throw new ResponseStatusException(HttpStatus.NOT_FOUND,e.getMessage(),e);
      }

    }
}
