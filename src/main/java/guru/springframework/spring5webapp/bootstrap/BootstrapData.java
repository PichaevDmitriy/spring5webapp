package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.domain.*;
import guru.springframework.spring5webapp.repositories.*;
import org.springframework.boot.*;
import org.springframework.stereotype.*;

import java.util.*;

@Component
public class BootstrapData implements CommandLineRunner {
    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;
    public BootstrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Author eric = new Author("Eric", "Events");
        Author rod = new Author("Rod", "Johnson");

        Author ericSaved = authorRepository.save(eric);
        Author rodSaved = authorRepository.save(rod);

        Book ddd = new Book("Domain Driven Design", "123456");
        Book noEJB = new Book("J2EE Development without EJB", "56789890");

        Book noEJBSaved = bookRepository.save(noEJB);
        Book dddSaved = bookRepository.save(ddd);

        Publisher publisher = new Publisher();
        publisher.setName("TestPublisher");
        publisher.setCity("Tashkent");
        publisher.setAddress("Taskent Darhan");
        publisher.setZipCode("Test zip");
        publisher.setState("State");

        Publisher publisherSaved = publisherRepository.save(publisher);
        dddSaved.setPublisher(publisherSaved);
        noEJBSaved.setPublisher(publisherSaved);

        ericSaved.getBooks().add(dddSaved);
        rodSaved.getBooks().add(noEJBSaved);

        bookRepository.save(dddSaved);
        bookRepository.save(noEJBSaved);
        authorRepository.save(ericSaved);
        authorRepository.save(rodSaved);

        System.out.println("In Bootstrap");
        System.out.println("Author Count: " + authorRepository.count());
        System.out.println("Book Count: " + bookRepository.count());
        System.out.println("Publisher Count: " + publisherRepository.count());
    }
}
