package guru.springframework.spring5webapp.services;

import guru.springframework.spring5webapp.domain.*;
import guru.springframework.spring5webapp.repositories.*;
import org.springframework.stereotype.*;

@Service
public class AuthorServiceImpl implements AuthorService {
    AuthorRepository authorRepository;

    public AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public Iterable<Author> findAll() {
        return authorRepository.findAll();
    }
}
