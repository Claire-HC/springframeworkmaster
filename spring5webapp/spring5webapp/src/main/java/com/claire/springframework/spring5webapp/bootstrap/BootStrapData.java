package com.claire.springframework.spring5webapp.bootstrap;

import com.claire.springframework.spring5webapp.domain.Author;
import com.claire.springframework.spring5webapp.domain.Book;
import com.claire.springframework.spring5webapp.domain.Publisher;
import com.claire.springframework.spring5webapp.repositories.AuthorRepository;
import com.claire.springframework.spring5webapp.repositories.BookRepository;
import com.claire.springframework.spring5webapp.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 *  Created by claire on 11/11/20
 */
@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Publisher harper = new Publisher();
        harper.setAddress("New York, New York, 10007");
        harper.setName("Harper Collins");

        Author eric = new Author("Eric", "Evans");
        Book book1 = new Book("Domain Driven project", "123344");
        eric.getBooks().add(book1);
        book1.getAuthors().add(eric);

        book1.setPublisher(harper);
        harper.getBooks().add(book1);

        authorRepository.save(eric);
        bookRepository.save(book1);
        publisherRepository.save(harper);


        Author rod = new Author("Rod", "Johnson");
        Book book2 = new Book("J2EE Development","123455");
        rod.getBooks().add(book2);
        book2.getAuthors().add(rod);

        //book2.setPublisher(harper);
        //harper.getBooks().add(book2);

        authorRepository.save(rod);
        bookRepository.save(book2);
        //publisherRepository.save(harper);

        System.out.println("Started in Bootstrap");
        System.out.println("Number of Books: " + bookRepository.count());
        System.out.println("Number of Publishers: " + harper.getBooks().size());

    }
}
