package bossbabies.com.a.service;

import bossbabies.com.a.dto.BookDto;

import java.util.List;

public interface BookInfoService {

    // 출간일 최근 top 8개
    List<BookDto> topOfFindByPubdate();

    //스토어 중 가장 잘 팔린 8개
    List<BookDto> topOfFindByOrderCount();
}
