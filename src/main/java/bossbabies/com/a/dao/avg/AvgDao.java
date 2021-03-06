package bossbabies.com.a.dao.avg;

import bossbabies.com.a.dto.avg.CategorySaleRateDto;
import bossbabies.com.a.dto.avg.SalesByPeriodDto;
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

    public List<SalesByPeriodDto> getSalesByPeriod(SalesByPeriodDto salesByPeriodDto){
        return session.selectList(nameSpace + "getSalesByPeriod", salesByPeriodDto);
    }
}
