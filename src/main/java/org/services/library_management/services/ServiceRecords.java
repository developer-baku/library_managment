package org.services.library_management.services;

import lombok.AllArgsConstructor;
import org.services.library_management.entities.Book;
import org.services.library_management.entities.Records;
import org.services.library_management.repository.RepositoryBook;
import org.services.library_management.repository.RepositoryPatron;
import org.services.library_management.repository.RepositoryRecords;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Calendar;
import java.util.Date;
import java.util.Optional;


@Service
@AllArgsConstructor
public class ServiceRecords {
    private final RepositoryBook repositoryBook;
    private final RepositoryPatron repositoryPatron;
    private final RepositoryRecords repositoryRecords;

    @Transactional
    public void borrowIt(Long bookId,Long patronId) throws Exception{
        var bookOp =repositoryBook.findById(bookId);
        var patronOp= repositoryPatron.findById(patronId);
        if (bookOp.isEmpty()||patronOp.isEmpty())
        { throw new Exception("either book or patron or both do not exist");}
        else if (bookOp.get().getAvailable()){
            Book book = bookOp.get();
            book.setAvailable(false);
            repositoryBook.save(book);
            Date date = Calendar.getInstance().getTime();
            repositoryRecords.save(Records.builder()
                            .patron(patronOp.get())
                            .book(bookOp.get())
                            .whenBorrowed(date)

                    .build());
        }

        else throw new Exception("book is not available, already borrowed by someone");


    }
    @Transactional
    public void returnIt(Long bookId, Long patronId) throws Exception{
        var bookOp =repositoryBook.findById(bookId);
        var patronOp= repositoryPatron.findById(patronId);
        if (bookOp.isEmpty()||patronOp.isEmpty())
        { throw new Exception("either book or patron or both do not exist");}
        else if (bookOp.get().getAvailable()){ throw new Exception("book have not been borrowed");}
          else {
            Optional<Records> optional = repositoryRecords.findAll().stream()
                    .filter(p-> p.getWhenReturned() == null && bookId.equals(p.getBook().getId()) && patronId.equals(p.getPatron().getId()))
                    .findFirst();
            if (optional.isEmpty()) {

                throw new Exception("the book has not been borrowed by that patron");
            }
            else {
               Records record= optional.get();
            bookOp.get().setAvailable(true);


              Date date = Calendar.getInstance().getTime();
            repositoryRecords.save(Records.builder()
                            .whenBorrowed(record.getWhenBorrowed())
                            .patron(patronOp.get())
                            .book(bookOp.get())
                            .id(record.getId())
                    .whenReturned(date)
                    .build());
        }}


    }
}
