package global.com.config.security;

import global.com.dao.UserInfo;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PermissionInterceptor implements HandlerInterceptor {
    private final Logger log = LoggerFactory.getLogger(PermissionInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        UserInfo userInfo=null;
        Subject subject = SecurityUtils.getSubject();
        userInfo= (UserInfo) subject.getPrincipal();
        if (null != userInfo) {
            return true;
        }else {
            return false;
        }
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        // >>>请求处理之后进行调用，但是在视图被渲染之前（Controller方法调用之后）");
        UserInfo user = null;
        try {
            Subject subject = SecurityUtils.getSubject();
            user = (UserInfo) subject.getPrincipal();
        } catch (Exception e) {
            log.info("当前用户没有登录");
        } finally {
            if (null != user) {
                // modelAndView不为空处理
                if (modelAndView != null) {
                    modelAndView.addObject("currentuser", user);
                }
            }
        }
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
