package global.com.web;

import global.com.config.SpringShiroConfig;
import global.com.dao.UserInfo;
import global.com.util.CaptchaUtil;
import global.com.util.JsonResult;
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
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;


@Controller
public class LoginController {
    // Log
    private final Logger log = LoggerFactory.getLogger(LoginController.class);
    //首页入口
    @RequestMapping({"/","/index"})
    public String index() {
        return "index";
    }
    //登录
    @RequestMapping("/login")
    public String login(HttpServletRequest request, Map<String ,Object> map, @RequestParam(value = "verCode",required = false) String verCode, UserInfo userInfo, Model model) {
        System.out.println("开始验证登录");
        System.out.println("验证码%s"+verCode);
        // 登录失败从request中获取shiro处理的异常信息。
        // shiroLoginFailure:就是shiro异常类的全类名.
        if (!StringUtils.isNotEmpty(userInfo.getUsername()) || !StringUtils.isNotEmpty(userInfo.getPassword())) {
            map.put("message", "账号或密码不能为空");
            model.addAttribute("map",map);
            return "login";
        }
        // 获取主体
        Subject subject = SecurityUtils.getSubject();
        try {
            // 调用安全认证框架的登录方法
            String password = SpringShiroConfig.hashedPassword(userInfo.getPassword());
            subject.login(new UsernamePasswordToken(userInfo.getUsername(), password));
            if (subject.isAuthenticated()){//验证是否登录成功
                if (!CaptchaUtil.ver(verCode, request)) {
                    CaptchaUtil.clear(request);  // 清除session中的验证码
                    map.put("message","验证码不正确");
                    model.addAttribute("map",map);
                    return "login";
                }
            }

        } catch (AuthenticationException ex) {
            log.info("登陆失败: " + ex.getMessage());
            map.put("message", "账号密码不正确，请重新输入");
            model.addAttribute("map",map);
            return "login";
        }
        // 此方法不处理登录成功,由shiro进行处理.
        return "index" ;
    }
    /**
     * logout
     */
    @RequestMapping("/logout")
    public String logout(HttpServletRequest request){
        // 获取主体
        Subject subject = SecurityUtils.getSubject();
        if (subject!=null){
            subject.logout();
        }
        //清除session中的验证码
        CaptchaUtil.clear(request);
        return "logout";
    }
    /**
     *生成验证码
     */
    @RequestMapping("/captcha")
    public void captcha(HttpServletRequest request, HttpServletResponse response) throws Exception {
        CaptchaUtil.out(request, response);
    }
    /*@RequestMapping("/captcha")
    public void captcha(HttpServletRequest request, HttpServletResponse response) throws Exception {
        // 设置位数
        CaptchaUtil.out(5, request, response);
        // 设置宽、高、位数
        CaptchaUtil.out(130, 48, 5, request, response);

        // 使用gif验证码
        GifCaptcha gifCaptcha = new GifCaptcha(130,48,4);
        CaptchaUtil.out(gifCaptcha, request, response);
*/
}
