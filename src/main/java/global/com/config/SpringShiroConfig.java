package global.com.config;


import global.com.config.security.MyAuthorizingRealm;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.cache.ehcache.EhCacheManager;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.CookieRememberMeManager;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.servlet.SimpleCookie;

import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.ehcache.EhCacheCacheManager;
import org.springframework.cache.ehcache.EhCacheManagerFactoryBean;
import org.springframework.cache.support.SimpleCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

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
	public MyAuthorizingRealm authorizingRealm() {
		MyAuthorizingRealm realm = new MyAuthorizingRealm();
		//realm.setCredentialsMatcher(credentialsMatcher());//设置解密规则
		return realm;
	}
	//SecurityManager 是 Shiro 架构的核心，通过它来链接Realm和用户(文档中称之为Subject.)
	@Bean
	public DefaultWebSecurityManager securityManager() {
		DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
		securityManager.setRealm(authorizingRealm()); //将Realm注入到SecurityManager中。
		securityManager.setCacheManager(ehCacheManager());
		securityManager.setRememberMeManager(cookieRememberMeManager());//加入cookieRememeberme
		return securityManager;
	}
	@Bean
	public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(org.apache.shiro.mgt.SecurityManager securityManager) {
		AuthorizationAttributeSourceAdvisor advisor = new AuthorizationAttributeSourceAdvisor();
		advisor.setSecurityManager(securityManager);
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
		filterChainDefinitionMap.put("/login", "anon");// 登录页面
		filterChainDefinitionMap.put("/favicon.ico", "anon");
		filterChainDefinitionMap.put("/index", "user");
		filterChainDefinitionMap.put("/", "user");
		filterChainDefinitionMap.put("/logout", "logout"); 		// 登出访问
		filterChainDefinitionMap.put("/**", "authc"); 		// 其他所有都需要登录且认证后访问
		shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);
		return shiroFilterFactoryBean;
	}
	// 注册统一异常处理bean
	//缓存业务
	@Bean
	public EhCacheManager ehCacheManager() {
		System.out.println("ShiroConfiguration.getEhCacheManager()");
		net.sf.ehcache.CacheManager cacheManager = net.sf.ehcache.CacheManager.getCacheManager("es");
		EhCacheManager ehCacheManager = new EhCacheManager();
		if (cacheManager==null){
			ehCacheManager.setCacheManagerConfigFile("classpath:config/ehcache-shiro.xml");
			return ehCacheManager;
		}else {
			ehCacheManager.setCacheManager(cacheManager);
			return ehCacheManager;
		}
	}

	@Bean
	public EhCacheManagerFactoryBean EhCacheManagerFactoryBean() {
		System.out.println("ShiroConfiguration.getEhCacheManagerFactoryBean()");
		//net.sf.ehcache.CacheManager cacheManager = net.sf.ehcache.CacheManager.getCacheManager("xxx");
		EhCacheManagerFactoryBean ehCacheManager = new EhCacheManagerFactoryBean();
		ehCacheManager.setShared(true);//也说是说通过这个来设置cache的基地是这里的Spring独用,还是跟别的(如hibernate的Ehcache共享)
		/*if (cacheManager==null){
			ehCacheManager.setConfigLocation(new ClassPathResource("config/ehcache.xml"));
			return ehCacheManager;
		}
		else {
			ehCacheManager.setCacheManager(cacheManager);*/
			return ehCacheManager;




	}
	@Bean
	public EhCacheCacheManager ehCacheCacheManager(EhCacheManagerFactoryBean factoryBean){
		System.out.println("CacheConfiguration.ehcacheManager()");
		return new EhCacheCacheManager(factoryBean.getObject());

	}


	/**
	 * cookie保存
	 */
	@Bean
	public SimpleCookie RememberSimpleCookie(){
		System.out.println("ShiroConfiguration.RememberSimpleCookie()");
		SimpleCookie simpleCookie=new SimpleCookie("RememberMe");//前段传入的记住我的name=RememberMe
		//存在时常
		simpleCookie.setMaxAge(2592000);
		return simpleCookie;

	}

	/**
	 * cookie管理对象
	 * @return
	 */
	@Bean
	public CookieRememberMeManager cookieRememberMeManager(){
		System.out.println("ShiroConfiguration.cookieRememberMeManager()");
		CookieRememberMeManager cookieRememberMeManager=new CookieRememberMeManager();
		cookieRememberMeManager.setCookie(RememberSimpleCookie());
		return cookieRememberMeManager;
	}
}
