package com.kaanaydemir.bookapi.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.proxy.HibernateProxy;

import java.time.LocalDate;
import java.util.Objects;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
@Table(name = "book")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "author")
    private Long authorId;

    @Column(name = "genre")
    private Long genreId;

    @Column(name = "page_count")
    private Integer pageCount;

    @Column(name = "publish_date")
    private LocalDate publishDate;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Book book = (Book) o;

        if (!id.equals(book.id)) return false;
        if (!name.equals(book.name)) return false;
        if (!authorId.equals(book.authorId)) return false;
        if (!Objects.equals(genreId, book.genreId)) return false;
        if (!Objects.equals(pageCount, book.pageCount)) return false;
        return Objects.equals(publishDate, book.publishDate);
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + name.hashCode();
        result = 31 * result + authorId.hashCode();
        result = 31 * result + (genreId != null ? genreId.hashCode() : 0);
        result = 31 * result + (pageCount != null ? pageCount.hashCode() : 0);
        result = 31 * result + (publishDate != null ? publishDate.hashCode() : 0);
        return result;
    }
}
