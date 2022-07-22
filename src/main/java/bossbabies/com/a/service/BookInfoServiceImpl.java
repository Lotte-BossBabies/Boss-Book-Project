package bossbabies.com.a.service;

import bossbabies.com.a.dao.book.BookDaoImpl;
import bossbabies.com.a.dto.main.PopularBookInfoDto;
import bossbabies.com.a.dto.main.RegisteredBookInfoDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookInfoServiceImpl implements BookInfoService{

    @Autowired
    BookDaoImpl dao;


    @Override
    public List<PopularBookInfoDto> topOfFindByStar() {
        return dao.topOfFindByStar();
    }

    @Override
    public List<RegisteredBookInfoDto> topOfFindByOrderCount() {

        return dao.topOfFindByOrderCount();
    }

    @Override
    public List<RegisteredBookInfoDto> findByCategoryList(String cateName) {

        //카테고리명 맞추기
        if(cateName.equals("all")){
            return dao.findByList();
        }

        // 카테고리 나누기
        List<RegisteredBookInfoDto> cateBookList = new ArrayList<>();

        if(cateName.equals("문학")) {
            cateBookList.addAll(dao.findByCategoryList("소설"));
            cateBookList.addAll(dao.findByCategoryList("시/에세이"));
        }else if(cateName.equals("사회과학")){
            cateBookList.addAll(dao.findByCategoryList("사회과학"));
            cateBookList.addAll(dao.findByCategoryList("자연과 과학"));
        }else if(cateName.equals("경제경영")){
            cateBookList.addAll(dao.findByCategoryList("경제경영"));
            cateBookList.addAll(dao.findByCategoryList("종교/역학"));
        }else if(cateName.equals("인문")){
            cateBookList.addAll(dao.findByCategoryList("역사와 문화"));
            cateBookList.addAll(dao.findByCategoryList("인문"));
            cateBookList.addAll(dao.findByCategoryList("자기계발"));
        }else if(cateName.equals("어린이/청소년")){
            cateBookList.addAll(dao.findByCategoryList("유아"));
            cateBookList.addAll(dao.findByCategoryList("아동"));
            cateBookList.addAll(dao.findByCategoryList("청소년"));
        }else if(cateName.equals("전문서적/교재")){
            cateBookList.addAll(dao.findByCategoryList("초등학습서"));
            cateBookList.addAll(dao.findByCategoryList("고등학습서"));
            cateBookList.addAll(dao.findByCategoryList("중등학습서"));
            cateBookList.addAll(dao.findByCategoryList("국어/외국어/사전"));
            cateBookList.addAll(dao.findByCategoryList("컴퓨터/인터넷"));
            cateBookList.addAll(dao.findByCategoryList("자격서/수험서"));
            cateBookList.addAll(dao.findByCategoryList("전공도서/대학교재"));
        }else{
            cateBookList.addAll(dao.searchRegisteredBook("잡지"));
            cateBookList.addAll(dao.searchRegisteredBook("만화/라이트노밸"));
            cateBookList.addAll(dao.searchRegisteredBook("가정과 생활"));
            cateBookList.addAll(dao.searchRegisteredBook("취미/레저"));
            cateBookList.addAll(dao.searchRegisteredBook("건강/뷰티"));
            cateBookList.addAll(dao.searchRegisteredBook("여행"));
            cateBookList.addAll(dao.searchRegisteredBook("가정과 생활"));
        }

        return cateBookList;
    }

    @Override
    public List<RegisteredBookInfoDto> searchRegisteredBook(String search) {


        return dao.searchRegisteredBook(search);
    }
}
