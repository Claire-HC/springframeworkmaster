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
        Author eric = new Author("Eric", "Evans");
        Book book1 = new Book("Domain Driven project", "12344");
        eric.getBooks().add(book1);
        book1.getAuthors().add(eric);

        authorRepository.save(eric);
        bookRepository.save(book1);

        Author rod = new Author("Rod", "Johnson");
        Book book2 = new Book("J2EE Development","123455");
        rod.getBooks().add(book2);
        book2.getAuthors().add(rod);

        authorRepository.save(rod);
        bookRepository.save(book2);

        System.out.println("Started in Bootstrap");
        System.out.println("Number of Books: " + bookRepository.count());

        Publisher harper = new Publisher("Harper Collins", "New York, New York, 10007");
        publisherRepository.save(harper);

        System.out.println("Number of publisher: " + publisherRepository.count());


    }
}
