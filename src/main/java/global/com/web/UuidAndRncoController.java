package global.com.web;

import global.com.util.uuid;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import sun.misc.Contended;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Controller
public class UuidAndRncoController {
    @RequestMapping("/getNumber")
    @ResponseBody
    public Map<String,Object> getNumber(){
        Map<String,Object> map=new HashMap<>();
        String file="lover";
        Integer num=10;
        try {
            uuid.WriterFun(file,num);
            uuid.Writeruuid(file,num);
            map.put("success","成功");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return map;
    }
}
