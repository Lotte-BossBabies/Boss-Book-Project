package bossbabies.com.a.dao;

import bossbabies.com.a.dto.avg.CategorySaleRateDto;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AvgDao {

    @Autowired
    SqlSession session;

    String nameSpace = "Admin.";

    public List<CategorySaleRateDto> getSaleRateByCategory(CategorySaleRateDto categorySaleRateDto) {
        return session.selectList(nameSpace + "getSaleRateByCategory", categorySaleRateDto);
    }
}
