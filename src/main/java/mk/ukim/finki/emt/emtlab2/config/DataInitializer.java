package mk.ukim.finki.emt.emtlab2.config;

import lombok.Getter;
import mk.ukim.finki.emt.emtlab2.model.Author;
import mk.ukim.finki.emt.emtlab2.model.Book;
import mk.ukim.finki.emt.emtlab2.model.Country;
import mk.ukim.finki.emt.emtlab2.model.enums.Category;
import mk.ukim.finki.emt.emtlab2.repository.AuthorRepository;
import mk.ukim.finki.emt.emtlab2.repository.BookRepository;
import mk.ukim.finki.emt.emtlab2.repository.CountryRepository;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Component
@Getter
public class DataInitializer {

    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;
    private final CountryRepository countryRepository;

    public static List<Country> countries = new ArrayList<>();
    public static List<Author> authors = new ArrayList<>();
    public static List<Book> books = new ArrayList<>();

    public DataInitializer(BookRepository bookRepository, AuthorRepository authorRepository, CountryRepository countryRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
        this.countryRepository = countryRepository;
    }


    @PostConstruct
    public void init(){
        Country country1 = new Country("Macedonia", "Europe");
        Country country2 = new Country("Greece", "Europe");
        Country country3 = new Country("Austria", "Europe");
        Country country4 = new Country("France", "Europe");
        Country country5 = new Country("Netherlands", "Europe");
        Country country6 = new Country("Belgium", "Europe");
        this.countryRepository.save(country1);
        this.countryRepository.save(country2);
        this.countryRepository.save(country3);
        this.countryRepository.save(country4);
        this.countryRepository.save(country5);
        this.countryRepository.save(country6);
        Author author1 = new Author("Zivko", "Cingo", country1);
        Author author2 = new Author("Blaze", "Koneski", country1);
        Author author3 = new Author("Nikos", "Kazantzakis", country2);
        Author author4 = new Author("Arthur", "Schnitzler", country3);
        Author author5 = new Author("Émile ", "Zola ", country4);
        Author author6 = new Author("Gerard ", "Reve  ", country5);
        Author author7 = new Author("Georges ", "Simenon  ", country6);
        this.authorRepository.save(author1);
        this.authorRepository.save(author2);
        this.authorRepository.save(author3);
        this.authorRepository.save(author4);
        this.authorRepository.save(author5);
        this.authorRepository.save(author6);
        this.authorRepository.save(author7);
        Book book1 = new Book("Maigret", Category.NOVEL, author7, 200);
        Book book2 = new Book("Parents Worry", Category.NOVEL, author6, 310);
        Book book3 = new Book("Sredba vo rajot", Category.DRAMA, author2, 140);
        Book book4 = new Book("Bunilo", Category.NOVEL, author1, 40);
        Book book5 = new Book("Nana", Category.NOVEL, author5, 70);
        Book book6 = new Book("Dream Storry", Category.DRAMA, author4, 240);
        Book book7 = new Book("Zorba the Greek", Category.NOVEL, author3, 10);
        this.bookRepository.save(book1);
        this.bookRepository.save(book2);
        this.bookRepository.save(book3);
        this.bookRepository.save(book4);
        this.bookRepository.save(book5);
        this.bookRepository.save(book6);
        this.bookRepository.save(book7);

    }
}
