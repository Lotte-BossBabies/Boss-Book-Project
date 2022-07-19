package bossbabies.com.a.service;


import bossbabies.com.a.dto.avg.CategorySaleRateDto;
import bossbabies.com.a.dao.avg.AvgDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

        System.out.println(total);

        List<CategorySaleRateDto> result = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            CategorySaleRateDto dto = list.get(i);
            dto.setPercent(((float) dto.getOrderCount() / (float) total) * 100);
            System.out.println(dto.getPercent());
            result.add(dto);
        }

        return result;
    }
}