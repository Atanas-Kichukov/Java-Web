package bg.softuni.books.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import java.util.LinkedList;
import java.util.List;

@Entity
@Table(name = "authors")
public class AuthorEntity extends BaseEntity {
    private String name;
    @OneToMany(mappedBy = "author")
    private List<BookEntity> books = new LinkedList<>();

    public String getName() {
        return name;
    }

    public AuthorEntity setName(String name) {
        this.name = name;
        return this;
    }

    public List<BookEntity> getBooks() {
        return books;
    }

    public AuthorEntity setBooks(List<BookEntity> books) {
        this.books = books;
        return this;
    }

    @Override
    public String toString() {
        return "AuthorEntity{" +
                "name='" + name + '\'' +
                '}';
    }
}
