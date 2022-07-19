package bossbabies.com.a.dto;


import java.sql.Timestamp;


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
    private Timestamp pubdate;
    private String publisher;

    public BookDto() {
    }

    public BookDto(String isbn, String title, String author, int price, String description, String image_url, String category, Timestamp datetime, String publisher) {
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
}
