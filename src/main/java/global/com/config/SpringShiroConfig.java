package global.com.config;


import global.com.config.security.AuthorizingRealm;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.codec.Base64;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.CookieRememberMeManager;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.servlet.SimpleCookie;
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;


@Configuration
public class SpringShiroConfig {
    private static String hashAlgorithmName = "md5";
    private static int hashIterations = 1;
	
	@Bean
	public HashedCredentialsMatcher credentialsMatcher() {
		HashedCredentialsMatcher matcher = new HashedCredentialsMatcher();
		matcher.setHashAlgorithmName(hashAlgorithmName);//散列算法
		matcher.setHashIterations(hashIterations); //散列次数
		return matcher;
	}
	
    public static String hashedPassword(String pwd) {
        Object hash = new SimpleHash(hashAlgorithmName, pwd, null, hashIterations);
        return hash.toString();
    }
    
	@Bean
	public AuthorizingRealm authorizingRealm() {
		AuthorizingRealm realm = new AuthorizingRealm();
		realm.setCredentialsMatcher(credentialsMatcher());//设置解密规则
		return realm;
	}
	/*@Bean
	public SimpleCookie simpleCookie() {
	    SimpleCookie simpleCookie = new SimpleCookie("rememberMe");
	    simpleCookie.setMaxAge(2592000);
	    return simpleCookie;
	}*/

	/**
	 * rememberMeManager管理器，写cookie，取出cookie生成用户信息
	 */
	/*@Bean
	public CookieRememberMeManager cookieRememberMeManager() {
	    CookieRememberMeManager cookieRememberMeManager = new CookieRememberMeManager();
	    cookieRememberMeManager.setCipherKey(Base64.decode("4AvVhmFLUs0KTA3Kprsdag=="));
	    cookieRememberMeManager.setCookie(simpleCookie());
	    return cookieRememberMeManager;
	}*/
	
	@Bean
	public DefaultWebSecurityManager securityManager() {
		DefaultWebSecurityManager manager = new DefaultWebSecurityManager();
		manager.setRealm(authorizingRealm());
		return manager;
	}
	/**
	 * 会话管理器
	 */
	/*@Bean
	public DefaultWebSessionManager defaultWebSessionManager() {
	    DefaultWebSessionManager defaultWebSessionManager = new DefaultWebSessionManager();
	    defaultWebSessionManager.setGlobalSessionTimeout(600000); // Session过期时间
	    defaultWebSessionManager.setDeleteInvalidSessions(true);
	    return defaultWebSessionManager;*/
	//}
	@Bean
	public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(org.apache.shiro.mgt.SecurityManager securityManager) {
		AuthorizationAttributeSourceAdvisor advisor = new AuthorizationAttributeSourceAdvisor();
		advisor.setSecurityManager( securityManager);
		System.out.println("s");
		return advisor;

	}
	@Bean
	public ShiroFilterFactoryBean shiroFilter() {
		ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
		shiroFilterFactoryBean.setSecurityManager(securityManager());
		shiroFilterFactoryBean.setLoginUrl("/login"); // 要求登录时的连接
		shiroFilterFactoryBean.setUnauthorizedUrl("/login");// 未认证时要跳转的连接
		shiroFilterFactoryBean.setSuccessUrl("/index");
		Map<String, String> filterChainDefinitionMap= new HashMap<String, String>();
		//filterChainDefinitionMap.put("/static/**","anon");		// 可匿名访问的资源
		filterChainDefinitionMap.put("/login", "anon");// 登录页面
		filterChainDefinitionMap.put("/favicon.ico", "anon");
		//filterChainDefinitionMap.put("/upload/**", "anon");		// 文件
		//filterChainDefinitionMap.put("/error", "anon");			// 错误页面
		filterChainDefinitionMap.put("/logout", "logout"); 		// 登出访问
		filterChainDefinitionMap.put("/**", "authc"); 		// 其他所有都需要登录且认证后访问
		shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);
		return shiroFilterFactoryBean;
	}
}
