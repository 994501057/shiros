package global.com.web;

import global.com.config.SpringShiroConfig;
import global.com.dao.UserInfo;
import org.apache.commons.lang.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;


@Controller
public class LoginController {
    // Log
    private final Logger log = LoggerFactory.getLogger(LoginController.class);

    @RequestMapping({"/","/index"})
    public String index() {
        return "index";
    }

    @RequestMapping("/login")
    public String login(HttpServletRequest request, Map<String ,Object> map, UserInfo userInfo) {
        System.out.println("开始验证登录");
        // 登录失败从request中获取shiro处理的异常信息。
        // shiroLoginFailure:就是shiro异常类的全类名.
        if (!StringUtils.isNotEmpty(userInfo.getUsername()) || !StringUtils.isNotEmpty(userInfo.getPassword())) {
            map.put("message", "账号或密码不能为空");
            return "login";
        }
        // 获取主体
        Subject subject = SecurityUtils.getSubject();
        try {
            // 调用安全认证框架的登录方法
            String password = SpringShiroConfig.hashedPassword(userInfo.getPassword());
            subject.login(new UsernamePasswordToken(userInfo.getUsername(), password));
        } catch (AuthenticationException ex) {
            log.info("登陆失败: " + ex.getMessage());
            map.put("message", "账号密码不正确，请重新输入");
            return "login";
        }
        // 此方法不处理登录成功,由shiro进行处理.
        return "index" ;
    }
    /**
     * logout
     */
    @RequestMapping("/logout")
    public String logout(){
        // 获取主体
        Subject subject = SecurityUtils.getSubject();
        if (subject!=null){
            subject.logout();
        }
        return "logout";
    }
}
