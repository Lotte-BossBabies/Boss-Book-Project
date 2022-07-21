package bossbabies.com.a.controller;

import bossbabies.com.a.dto.avg.CategorySaleRateDto;
import bossbabies.com.a.dto.avg.SalesByPeriodDto;
import bossbabies.com.a.service.AvgService;
import com.google.gson.Gson;
import org.apache.http.HttpResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Controller
public class AvgController {

    Logger logger = LoggerFactory.getLogger(AvgController.class);

    @Autowired
    AvgService service;

    @RequestMapping(value = "chart.do", method = RequestMethod.GET)
    public String getSaleRateByCategory(Model model, CategorySaleRateDto categorySaleRateDto, SalesByPeriodDto salesByPeriodDto) {
        List<CategorySaleRateDto> list = service.getSaleRateByCategory(categorySaleRateDto);
        model.addAttribute("saleRateByCategory", list);

        return "avg";
    }

    @RequestMapping(value = "line-chart.do", method = RequestMethod.GET)
    @ResponseBody
    public void getSalesByPeriod(HttpServletResponse response, @RequestParam String beforeStr, @RequestParam String afterStr, Model model) throws IOException {
        System.out.println("getSalesByPeriod");
        List<SalesByPeriodDto> list = service.getSalesByPeriod();
        model.addAttribute("before", beforeStr);
        model.addAttribute("after", afterStr);
        System.out.println("list: " + list);
        if (beforeStr.equals("") || afterStr.equals("")) {
            // 날짜 선택하지 않았을 경우 예외처리
            return;
        }

        List<SalesByPeriodDto> periodList = new ArrayList<SalesByPeriodDto>();
        int beforeInt = Integer.parseInt(beforeStr); // 220710
        int afterInt = Integer.parseInt(afterStr);   // 220719
        System.out.println("before: " + beforeInt + " after: " + afterInt);
        for (SalesByPeriodDto dto : list) {
            int orderDate = Integer.parseInt(dto.getOrderDate().split("-")[0].substring(2, 4) + dto.getOrderDate().split("-")[1] + dto.getOrderDate().split("-")[2]);
            if (beforeInt <= orderDate && orderDate <= afterInt) {
                System.out.println("orderDate : " + orderDate);
                periodList.add(dto);
            }
        }
        String json = new Gson().toJson(periodList);
        response.getWriter().print(json);
    }

}
