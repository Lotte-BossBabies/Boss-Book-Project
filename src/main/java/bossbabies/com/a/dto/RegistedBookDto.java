package bossbabies.com.a.dto;

import java.time.LocalDateTime;

public class RegistedBookDto {

    private int registedBookId;
    private int bookId;
    private int sellerId;
    private int orderCount;
    private int bookCount;
    private LocalDateTime registerDate;
    private boolean sellStatus;

    public RegistedBookDto() {

    }

    public RegistedBookDto(int registedBookId, int bookId, int sellerId, int orderCount,
        int bookCount,
        LocalDateTime registerDate, boolean sellStatus) {
        this.registedBookId = registedBookId;
        this.bookId = bookId;
        this.sellerId = sellerId;
        this.orderCount = orderCount;
        this.bookCount = bookCount;
        this.registerDate = registerDate;
        this.sellStatus = sellStatus;
    }

    public int getRegistedBookId() {
        return registedBookId;
    }

    public void setRegistedBookId(int registedBookId) {
        this.registedBookId = registedBookId;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public int getSellerId() {
        return sellerId;
    }

    public void setSellerId(int sellerId) {
        this.sellerId = sellerId;
    }

    public int getOrderCount() {
        return orderCount;
    }

    public void setOrderCount(int orderCount) {
        this.orderCount = orderCount;
    }

    public int getBookCount() {
        return bookCount;
    }

    public void setBookCount(int bookCount) {
        this.bookCount = bookCount;
    }

    public LocalDateTime getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(LocalDateTime registerDate) {
        this.registerDate = registerDate;
    }

    public boolean isSellStatus() {
        return sellStatus;
    }

    public void setSellStatus(boolean sellStatus) {
        this.sellStatus = sellStatus;
    }
}
