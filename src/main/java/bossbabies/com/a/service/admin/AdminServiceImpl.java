package bossbabies.com.a.service.admin;

import bossbabies.com.a.dao.registeredBook.RegisteredBookDao;
import bossbabies.com.a.dto.RegisteredBookDto;
import bossbabies.com.a.parameterVO.CategoryAndKeywordVO;
import bossbabies.com.a.parameterVO.IdAndCountVO;
import bossbabies.com.a.parameterVO.SellerAndCategoryVO;
import bossbabies.com.a.parameterVO.StatusAndRegisteredBookIdVO;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * [프로젝트]롯데e커머스_자바전문가과정
 * [시스템명]온라인도서쇼핑몰 구현 프로젝트
 * [팀   명]BossBabies
 * -----------------------------------------------------------
 * 수정일자           수정자         수정내용
 * 2022.07.19       안채영         신규생성
 * -----------------------------------------------------------
 */

@Service
public class AdminServiceImpl implements AdminService{

    @Autowired
    RegisteredBookDao dao;

    @Override
    public List<RegisteredBookDto> getRegisteredBookList(int sellerId, String category) {

        SellerAndCategoryVO vo = new SellerAndCategoryVO(sellerId, category);

        return dao.getRegisteredBookList(vo);
    }

    @Override
    public List<RegisteredBookDto> getRegisteredBookListBySellCount(int sellerId, String category) {

        SellerAndCategoryVO vo = new SellerAndCategoryVO(sellerId, category);

        return dao.getRegisteredBookListBySellCount(vo);
    }

    @Override
    public List<RegisteredBookDto> getRegisteredBookListByKeyword(int sellerId, String category, String keyword) {

        CategoryAndKeywordVO vo = new CategoryAndKeywordVO(category, keyword, sellerId);

        return dao.getRegisteredBookListByKeyword(vo);
    }

    @Override
    public int updateStock(int registeredBookId, int newCount, int discount) {

        IdAndCountVO vo = new IdAndCountVO(registeredBookId, newCount, discount);

        return dao.updateStock(vo);
    }

    @Override
    public int updateRegisteredBook(int status, int registeredBookId) {

        StatusAndRegisteredBookIdVO vo = new StatusAndRegisteredBookIdVO(status, registeredBookId);

        return dao.updateRegisteredBook(vo);
    }

    @Override
    public int updateDeliveryCompleted(int status, int registeredBookId) {

        StatusAndRegisteredBookIdVO vo = new StatusAndRegisteredBookIdVO(status, registeredBookId);

        return dao.updateDeliveryCompleted(vo);
    }
}
