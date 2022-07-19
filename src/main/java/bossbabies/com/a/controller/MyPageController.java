package bossbabies.com.a.controller;

import bossbabies.com.a.dto.OrderedBookDto;
import bossbabies.com.a.dto.MyPageDto;
import bossbabies.com.a.dto.LikedBookDto;
import bossbabies.com.a.service.MyPageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class MyPageController {

    @Autowired
    MyPageService service;

    @GetMapping("member-detail.do")
    public String orderList(MyPageDto md, Model model) {
        MyPageDto member = service.getMember(md);
        List<OrderedBookDto> orderItemList = service.getOrderList(md);
        List<LikedBookDto> likeItemList = service.getLikeList(md);

        model.addAttribute("member", member);
        model.addAttribute("orderList", orderItemList);
        model.addAttribute("likeList", likeItemList);

        return "MyPage";
    }
}
