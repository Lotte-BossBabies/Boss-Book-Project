package bossbabies.com.a.dto;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.Timestamp;

public class ApiDto {
    private int book_id;
    private String isbn;
    private String title;
    private String author;
    private int price;
    private String description;
    private String image_url;
    private String category;
    private Timestamp datetime;
    private String publisher;

    public ApiDto() {
    }

    public ApiDto(String isbn, String title, String author, int price, String description, String image_url, String category, Timestamp datetime, String publisher) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.price = price;
        this.description = description;
        this.image_url = image_url;
        this.category = category;
        this.datetime = datetime;
        this.publisher = publisher;
    }

    public ApiDto(int book_id, String isbn, String title, String author, int price, String description, String image_url, String category, Timestamp datetime, String publisher) {
        this.book_id = book_id;
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.price = price;
        this.description = description;
        this.image_url = image_url;
        this.category = category;
        this.datetime = datetime;
        this.publisher = publisher;
    }

    public int getBook_id() {
        return book_id;
    }

    public void setBook_id(int book_id) {
        this.book_id = book_id;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Timestamp getDatetime() {
        return datetime;
    }

    public void setDatetime(Timestamp datetime) {
        this.datetime = datetime;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    @Override
    public String toString() {
        return "ApiDto{" +
            "book_id=" + book_id +
            ", isbn='" + isbn + '\'' +
            ", title='" + title + '\'' +
            ", author='" + author + '\'' +
            ", price=" + price +
            ", description='" + description + '\'' +
            ", image_url='" + image_url + '\'' +
            ", category='" + category + '\'' +
            ", datetime=" + datetime +
            ", publisher='" + publisher + '\'' +
            '}';
    }
}
