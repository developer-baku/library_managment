package org.services.library_management.services;

import lombok.AllArgsConstructor;
import org.services.library_management.dto.RequestBook;
import org.services.library_management.dto.ResponseBook;
import org.services.library_management.dto.ResponsePatron;
import org.services.library_management.entities.Book;
import org.services.library_management.repository.RepositoryBook;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ServiceBook {
    private final RepositoryBook repositoryBook;
    public List<ResponseBook> getBooks() {
        return repositoryBook.findAll().stream().map(f-> ResponseBook.builder()
                .tittle(f.getTittle())
                .publicationYear(f.getPublicationYear())
                .author(f.getAuthor())
                .available(f.getAvailable())
                .isbn(f.getIsbn())
                .id(f.getId())
                .build()).toList();
    }

    public ResponseBook getBookById(Long id) throws Exception{
        var o=repositoryBook.findById(id);
         if(o.isPresent()) {
             var book = o.get();

             return
                 ResponseBook.builder()
                         .tittle(book.getTittle())
                         .publicationYear(book.getPublicationYear())
                         .author(book.getAuthor())
                         .available(book.getAvailable())
                         .isbn(book.getIsbn())
                         .id(book.getId())
                         .build();

                  }
         else throw new Exception();
    }

    public void updateBook(Long id,RequestBook requestBook) throws Exception {
        var op= repositoryBook.findById(id);
       if (op.isPresent()){
           repositoryBook.save(Book.builder()
                           .id(id)
                   .tittle(requestBook.getTittle())
                   .author(requestBook.getAuthor())
                   .isbn(requestBook.getIsbn())
                   .publicationYear(requestBook.getPublicationYear())
                           .available(op.get().getAvailable())

                   .build());
       }
       else throw new Exception();
    }

    public void deleteBook(Long id) throws Exception {
        if (repositoryBook.findById(id).isPresent()){
            repositoryBook.deleteById(id);
        }

       else throw new Exception();
    }

    public void addBook(RequestBook requestBook) {

        repositoryBook.save(Book.builder()
                        .tittle(requestBook.getTittle())
                        .author(requestBook.getAuthor())
                        .isbn(requestBook.getIsbn())
                        .publicationYear(requestBook.getPublicationYear())
                        .available(true)

                .build());
    }
}
