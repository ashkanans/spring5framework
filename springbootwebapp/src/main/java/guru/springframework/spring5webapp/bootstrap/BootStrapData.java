package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.domain.Author;
import guru.springframework.spring5webapp.domain.Book;
import guru.springframework.spring5webapp.domain.Publisher;
import guru.springframework.spring5webapp.repositories.AuthorRepositories;
import guru.springframework.spring5webapp.repositories.BookRepositories;
import guru.springframework.spring5webapp.repositories.PublisherRepositories;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * Created by jt on 12/23/19.
 */
@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepositories authorRepository;
    private final BookRepositories bookRepository;
    private final PublisherRepositories publisherRepositories;

    public BootStrapData(AuthorRepositories authorRepository, BookRepositories bookRepository, PublisherRepositories publisherRepositories) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepositories = publisherRepositories;
    }

    @Override
    public void run(String... args){

        Publisher publisher = new Publisher();
        publisher.setName("SFG Publisher");
        publisher.setCity("Roma");
        publisher.setState("Lazio");

        publisherRepositories.save(publisher);

        Author eric = new Author("Eric", "Evans");
        Book ddd = new Book("Domain Driven Design", "123123");
        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);

        ddd.setPublisher(publisher);
        publisher.getBooks().add(ddd);

        authorRepository.save(eric);
        bookRepository.save(ddd);
        publisherRepositories.save(publisher);

        Author rod = new Author("Rod", "Johnson");
        Book noEJB = new Book("J2EE Development without EJB", "3939459459");
        rod.getBooks().add(noEJB);
        noEJB.getAuthors().add(rod);
        publisher.getBooks().add(noEJB);

        authorRepository.save(rod);
        bookRepository.save(noEJB);
        publisherRepositories.save(publisher);

        System.out.println("Starting Bootstrap...");
        System.out.println("Number of book: " + bookRepository.count());
        System.out.println("Number of publisher: " + publisherRepositories.count());
        System.out.println("Publisher number of books: " + publisher.getBooks().size());
    }
}
