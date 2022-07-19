package bossbabies.com.a.controller;

import bossbabies.com.a.service.KakaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;

@Controller
public class KakaoController {
    @Autowired
    private KakaoService us;

    @RequestMapping(value = "/kakaoLogin.do", method = RequestMethod.GET)
    public String kakaoLogin(@RequestParam(value = "code", required = false) String code) throws Exception {
        System.out.println("#########" + code);
        String access_Token = us.getAccessToken(code);
        HashMap<String, Object> userInfo = us.getUserInfo(access_Token);
        System.out.println("###access_Token#### : " + access_Token);
        System.out.println("###nickname#### : " + userInfo.get("nickname"));
        System.out.println("###email#### : " + userInfo.get("email"));
        return "member/testPage";
    }

}
