package com.example.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {


    @Autowired
    AuthorRepository  authorRepository;


    @Autowired
    BookRepository  bookRepository;

    @Test
    @Rollback(false)
    public void contextLoads() {




        // Magdo, Madziu, Magdaleno
        Author author1 = new Author("Magda", "Magdaleńska");
        Book book1 = new Book("Tytuł książki 1", "123456abc");

        author1.getBooks().add(book1);
        book1.getAuthors().add(author1);

        bookRepository.save(book1);
        authorRepository.save(author1);


        // Cygan
        Author author2 = new Author("Cygan", "Śniady");
        Book book2 = new Book("Jak sprzedać dywan", "222");
        Book book3 = new Book("Jak sprzedać dywan2", "2223");

        author2.getBooks().add(book2);
        author2.getBooks().add(book3);
        book2.getAuthors().add(author2);
        book3.getAuthors().add(author2);

        bookRepository.save(book2);
        bookRepository.save(book3);
        authorRepository.save(author2);

        final List<Author> authors = authorRepository.findAll();

        assertThat(authors).hasSize(2);


    }

}
