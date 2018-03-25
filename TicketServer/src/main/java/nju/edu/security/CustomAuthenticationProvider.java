package nju.edu.security;

import nju.edu.dao.UserDao;
import nju.edu.model.User;
import nju.edu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.*;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

/**
 * Created by xiaoJun on 2018/3/7.
 */
@Component
public class CustomAuthenticationProvider implements AuthenticationProvider{

    @Autowired
    private UserService userService;

    @Autowired
    private UserDao userDao;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        // 获取认证的用户名 & 密码
        String name = authentication.getName();
        String password = authentication.getCredentials().toString();

        if (userService == null){
            System.out.println(name + "  " + password);
        }
        User user =this.userService.login(name, password);
        if (user == null){
            throw new BadAccountException("用户名或密码错误",BadAccountException.BAD_Credentials);
        }

        String type;
        switch (user.getType()){
            case UserRole.MEMBER:
                type = UserRole.ROLE_MEMBER;
                break;
            case UserRole.VENUE:
                type = UserRole.ROLE_VENUE;
                break;
            case UserRole.MANAGER:
                type = UserRole.ROLE_MANAGER;
                break;
            default:
                type = "";
        }

        ArrayList<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new UserRole(type));
        // 生成令牌
        Authentication auth = new UsernamePasswordAuthenticationToken(name, password, authorities);
        return auth;
    }

    // 是否可以提供输入类型的认证服务
    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }
}
