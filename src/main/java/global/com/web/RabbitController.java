package global.com.web;

import global.com.Rabbit.MsgProducer;
import org.apache.tomcat.websocket.WsRemoteEndpointAsync;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RabbitController {
    @Autowired
    private MsgProducer msgProducer;

    @RequestMapping("/hello")
    public String  hello(){
        String content="akahdkd";
        msgProducer.sendMsg(content);
        return "redirect:list";
    }


}
