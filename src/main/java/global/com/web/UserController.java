package global.com.web;

import global.com.dao.User;
import global.com.dao.UserInfo;
import global.com.service.UserService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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
    public String userInfo(){
        String username="admin";
        UserInfo userInfo= userService.findUserByUsername(username);
        System.out.println(userInfo.getPassword());
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
    public Map<String ,Object> get(@RequestParam("id") String id , Model model){
        System.out.println(id);
        Map<String ,Object> map=new HashMap<String ,Object>();
        User user= null;
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
    public Map<String ,Object> add(@RequestParam("t_id") String id ,
                                   @RequestParam("t_name") String username ,
                                   @RequestParam("t_pwd") String pwd ,
                                   @RequestParam("t_email") String email ,Model model){
        System.out.println(id);
        Map<String ,Object> map=new HashMap<String ,Object>();
        User user= null;
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
}
