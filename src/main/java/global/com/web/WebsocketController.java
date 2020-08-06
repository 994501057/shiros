package global.com.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;

@CrossOrigin
@Controller
public class WebsocketController {
    @RequestMapping("/webSocket")
    public String index(){
        return "webSocket";
    }
}
