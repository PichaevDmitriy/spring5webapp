package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.domain.*;
import guru.springframework.spring5webapp.repositories.*;
import org.springframework.boot.*;
import org.springframework.stereotype.*;

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
        Author eric = new Author();
        eric.setFirstName("Eric");
        eric.setLastName("Events");

        Author rod = new Author();
        rod.setFirstName("Rod");
        rod.setLastName("Johnson");

        Author ericSaved = authorRepository.save(eric);
        Author rodSaved = authorRepository.save(rod);

        Book ddd = new Book();
        ddd.setTitle("Domain Driven Design");
        ddd.setIsbn("123456");

        Book noEJB = new Book();
        noEJB.setTitle("J2EE Development without EJB");
        noEJB.setIsbn("56789890");


        Book noEJBSaved = bookRepository.save(noEJB);
        Book dddSaved = bookRepository.save(ddd);

        Publisher publisher = new Publisher();
        publisher.setPublisherName("TestPublisher");
        publisher.setCity("Tashkent");
        publisher.setAddress("Taskent Darhan");
        publisher.setZipCode("Test zip");

        Publisher publisherSaved = publisherRepository.save(publisher);
        dddSaved.setPublisher(publisherSaved);
        noEJBSaved.setPublisher(publisherSaved);

        bookRepository.save(dddSaved);
        bookRepository.save(noEJBSaved);


        ericSaved.getBooks().add(dddSaved);
        rodSaved.getBooks().add(noEJBSaved);

        System.out.println("In Bootstrap");
        System.out.println("Author Count: " + authorRepository.count());
        System.out.println("Book Count: " + bookRepository.count());
        System.out.println("Publisher Count: " + publisherRepository.count());
    }
}
