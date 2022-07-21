package bossbabies.com.a.service;


import bossbabies.com.a.dto.avg.CategorySaleRateDto;
import bossbabies.com.a.dao.avg.AvgDao;
import bossbabies.com.a.dto.avg.SalesByPeriodDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Service
public class AvgService {

    @Autowired
    AvgDao dao;

    public List<CategorySaleRateDto> getSaleRateByCategory(CategorySaleRateDto categorySaleRateDto) {
        List<CategorySaleRateDto> list = dao.getSaleRateByCategory(categorySaleRateDto);

        int total = list.stream()
                .mapToInt(CategorySaleRateDto::getOrderCount)
                .sum();


        List<CategorySaleRateDto> result = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            CategorySaleRateDto dto = list.get(i);
            dto.setPercent(((float) dto.getOrderCount() / (float) total) * 100);
            result.add(dto);
        }

        return result;
    }

    public List<SalesByPeriodDto> getSalesByPeriod(SalesByPeriodDto salesByPeriodDto) {
        return dao.getSalesByPeriod(salesByPeriodDto);
    }
}
