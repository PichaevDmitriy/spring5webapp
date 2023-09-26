package guru.springframework.spring5webapp.services;

import guru.springframework.spring5webapp.domain.*;
import guru.springframework.spring5webapp.repositories.*;
import org.springframework.stereotype.*;

@Service
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public Iterable<Book> findAll() {
        return bookRepository.findAll();
    }
}
