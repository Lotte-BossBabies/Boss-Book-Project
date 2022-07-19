package bossbabies.com.a.controller;

import bossbabies.com.a.dto.mypage.OrderedBookDto;
import bossbabies.com.a.dto.mypage.MyPageDto;
import bossbabies.com.a.dto.mypage.LikedBookDto;
import bossbabies.com.a.service.MyPageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class MyPageController {

    @Autowired
    MyPageService service;

    @GetMapping("mypage.do")
    public String orderList(MyPageDto md, Model model) {
        MyPageDto member = service.getMember(md);
        List<OrderedBookDto> orderItemList = service.getOrderList(md);
        List<LikedBookDto> likeItemList = service.getLikeList(md);

        model.addAttribute("member", member);
        model.addAttribute("orderList", orderItemList);
        model.addAttribute("likeList", likeItemList);

        return "myPage";
    }

    @GetMapping("cancelOrder.do")
    public String cancelOrder(int orderId, int memberId) {
        service.cancelOrder(orderId);

        return "redirect:/mypage.do?memberId=" + memberId;
    }

    @GetMapping("deleteLike.do")
    public String deleteLike(int likeId, int memberId){
        service.deleteLike(likeId);

        return "redirect:/mypage.do?memberId=" + memberId;
    }

}
