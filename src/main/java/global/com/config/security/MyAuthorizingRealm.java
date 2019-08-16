package global.com.config.security;

import global.com.dao.SysPermission;
import global.com.dao.SysRole;
import global.com.dao.UserInfo;
import global.com.service.UserService;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.SimplePrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.Resource;

public class MyAuthorizingRealm extends org.apache.shiro.realm.AuthorizingRealm{
    @Resource
    private UserService userService;

    /**
     * 授权
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        System.out.println("开始权限配置");
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        UserInfo userInfo= (UserInfo) principalCollection.getPrimaryPrincipal();
        for (SysRole sysRole:userInfo.getRoleList()){
            authorizationInfo.addRole(sysRole.getRole());
            for (SysPermission sysPermission:sysRole.getPermissions()){
                authorizationInfo.addStringPermission(sysPermission.getPermission());
            }
        }
        return authorizationInfo;
    }
    /**
     * 认证
     * @param authenticationToken
     * @return
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        System.out.println("开始身份认证");
        String username= (String) authenticationToken.getPrincipal();
        UserInfo userInfo=userService.findUserByUsername(username);
        if (userInfo==null){
            return null;
        }

        SimpleAuthenticationInfo authenticationInfo= new SimpleAuthenticationInfo( userInfo ,userInfo.getPassword(),getName());
        return authenticationInfo;
    }
}
