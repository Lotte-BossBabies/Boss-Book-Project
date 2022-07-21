package bossbabies.com.a.service;

import bossbabies.com.a.dto.main.PopularBookInfoDto;
import bossbabies.com.a.dto.main.RegisteredBookInfoDto;

import java.util.List;

public interface BookInfoService {

    // 평점 순 8개
    List<PopularBookInfoDto> topOfFindByStar();

    //스토어 중 가장 잘 팔린 8개
    List<RegisteredBookInfoDto> topOfFindByOrderCount();

    //카테고리별 상품 리스트
    List<RegisteredBookInfoDto> findByCategoryList(String cateName);

    List<RegisteredBookInfoDto> searchRegisteredBook(String search);
}
