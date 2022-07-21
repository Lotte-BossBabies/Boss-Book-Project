package bossbabies.com.a.service;

import bossbabies.com.a.dao.book.BookDaoImpl;
import bossbabies.com.a.dto.BookDto;
import bossbabies.com.a.dto.main.PopularBookInfoDto;
import bossbabies.com.a.dto.main.RegisteredBookInfoDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

        return dao.findByCategoryList(cateName);
    }

    @Override
    public List<RegisteredBookInfoDto> searchRegisteredBook(String search) {
        return dao.searchRegisteredBook(search);
    }
}
