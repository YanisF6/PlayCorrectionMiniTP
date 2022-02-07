package models;

import io.ebean.Finder;
import io.ebean.Model;
import play.data.validation.Constraints;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Book extends Model {

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Id
    @Constraints.Required
    public Integer id;

    @Constraints.MaxLength(255)
    @Constraints.MinLength(5)
    @Constraints.Required
    public String title;

    @Constraints.Required
    @Constraints.Min(5)
    @Constraints.Max(100)
    public Integer price;

    // author relation ManyToOne
    @Constraints.Required
    public String author;

    public static Finder<Integer,Book> find = new Finder<>(Book.class);
}
