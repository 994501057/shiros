package global.com.web;

import global.com.dao.User;
import global.com.dao.UserInfo;
import global.com.service.UserService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Controller
@RequestMapping("/userInfo")
public class UserController {
    @Autowired
    private UserService userService;

    /**
     * 用户查询.
     * @return
     */
    @RequestMapping("/userList")
    @RequiresPermissions("userInfo:view")
    public String userInfo(Model model){
        String username="admin";
        UserInfo userInfo= userService.findUserByUsername(username);
        System.out.println(userInfo.getPassword());
        model.addAttribute("userInfo",userInfo);
        return "userInfo";
    }

    /**
     * 用户添加;
     * @return
     */
    @RequestMapping("/userAdd")
    @RequiresPermissions("userInfo:add")
    public String userInfoAdd(){
        return "userAdd";
    }

    @RequestMapping("/userDel")
    @RequiresPermissions("userInfo:del")
    public String userInfoDel() {
        return "userDel";
    }

    @RequestMapping("/get")
    @ResponseBody
    public Map<String ,Object> get(@RequestParam("id") Long id , Model model){
        System.out.println(id);
        Map<String ,Object> map=new HashMap<String ,Object>();
        User user=new User();
        try {
            user = userService.findUserById(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        model.addAttribute("user",user);
        map.put("x",model);
        return map;
    }
    @RequestMapping("/adds")

    public String adds( Model model){

        return "addProject";
    }

    @RequestMapping("/add")
    @ResponseBody
    public Map<String ,Object> add(@RequestParam("t_id") Long id ,
                                   @RequestParam("t_name") String username ,
                                   @RequestParam("t_pwd") String pwd ,
                                   @RequestParam("t_email") String email ,Model model){
        System.out.println(id);
        Map<String ,Object> map=new HashMap<String ,Object>();
        User user= new User();
        try {
            user.setId(id);
            user.setUsername(username);
            user.setPwd(pwd);
            user.setEmail(email);
            userService.save(user);
        } catch (Exception e) {
            e.printStackTrace();
        }
        model.addAttribute("user",user);
        map.put("x",model);
        return map;
    }
    /**
     *
     * cookie
     */
    @RequestMapping("/setCookies")
    @ResponseBody
    public String setCookie(HttpServletResponse response){
        Cookie cookie=new Cookie("cookieId","helloworld");
        response.addCookie(cookie);
        return "SUCCESS";

    }
    /**
     * 获得cookie
     *
     */
    @RequestMapping("getCookie")
    @ResponseBody
    public String getCookie(@CookieValue String cookieId){
        System.out.println(cookieId);
        return "SUCCESS";
    }
}
