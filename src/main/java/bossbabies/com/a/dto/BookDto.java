package bossbabies.com.a.dto;

import java.time.Instant;

/**
 * [프로젝트]롯데e커머스_자바전문가과정
 * [시스템명]도서 테이블 도메인
 * [팀   명]BossBabies
 * -----------------------------------------------------------
 * 수정일자           수정자         수정내용
 * 2022.07.18       김혜연         신규생성
 * -----------------------------------------------------------
 */

public class BookDto {


    private int book_id;

    private String isbn;

    private String title;

    private String author;

    private int price;

    private String description;

    private String image_url;

    private String category;

    private Instant pubdate;

    private String publisher;

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

    public Instant getPubdate() {
        return pubdate;
    }

    public void setPubdate(Instant pubdate) {
        this.pubdate = pubdate;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }
    
    public BookDto() {
    }
    
    public BookDto(String isbn, String title, String author, int price, String description, String image_url, String category, Instant datetime, String publisher) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.price = price;
        this.description = description;
        this.image_url = image_url;
        this.category = category;
        this.pubdate = datetime;
        this.publisher = publisher;
    }

    @Override
    public String toString() {
        return "BookDto{" +
                "book_id=" + book_id +
                ", isbn='" + isbn + '\'' +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", price=" + price +
                ", description='" + description + '\'' +
                ", image_url='" + image_url + '\'' +
                ", category='" + category + '\'' +
                ", pubdate=" + pubdate +
                ", publisher='" + publisher + '\'' +
                '}';
    }
}
