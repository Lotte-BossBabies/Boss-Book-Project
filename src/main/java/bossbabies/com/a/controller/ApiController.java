package bossbabies.com.a.controller;

import bossbabies.com.a.service.ApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ApiController {

    @Autowired
    ApiService service;

    private final String url = "https://book.interpark.com/api/bestSeller.api?key=649BE70679EC7BD901874C52E0490CD59988BA2E9E1A48AC7E686EA7FA9D6D09" +
        "&categoryId=102&output=json";


}
