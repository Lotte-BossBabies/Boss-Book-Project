package bossbabies.com.a.controller;

import bossbabies.com.a.dto.avg.CategorySaleRateDto;
import bossbabies.com.a.dto.avg.SalesByPeriodDto;
import bossbabies.com.a.service.AvgService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class AvgController {

    Logger logger = LoggerFactory.getLogger(AvgController.class);

    @Autowired
    AvgService service;

    @RequestMapping(value = "chart.do", method = RequestMethod.GET)
    public String getSaleRateByCategory(Model model, CategorySaleRateDto categorySaleRateDto, SalesByPeriodDto salesByPeriodDto) {
        List<CategorySaleRateDto> list1 = service.getSaleRateByCategory(categorySaleRateDto);
        model.addAttribute("saleRateByCategory", list1);

        List<SalesByPeriodDto> list2 = service.getSalesByPeriod();
        model.addAttribute("salesByPeriod", list2);
        return "avg";
    }
}
