package bossbabies.com.a.dto.mypage;

import java.time.Instant;

public class MyPageReviewDto {
    private String content;
    private Integer star;
    private Instant reviewDate;
    private String title;
    private String imageUrl;

    public MyPageReviewDto() {
    }

    public MyPageReviewDto(String content, Integer star, Instant reviewDate, String title, String imageUrl) {
        this.content = content;
        this.star = star;
        this.reviewDate = reviewDate;
        this.title = title;
        this.imageUrl = imageUrl;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getStar() {
        return star;
    }

    public void setStar(Integer star) {
        this.star = star;
    }

    public Instant getReviewDate() {
        return reviewDate;
    }

    public void setReviewDate(Instant reviewDate) {
        this.reviewDate = reviewDate;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
