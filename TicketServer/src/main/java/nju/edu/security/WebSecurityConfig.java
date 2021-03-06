package nju.edu.security;

import nju.edu.filters.JWTAuthenticationFilter;
import nju.edu.filters.JWTLoginFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 * Created by xiaoJun on 2018/3/7.
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private CustomAuthenticationProvider customAuthenticationProvider;

    // 设置 HTTP 验证规则
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // 关闭csrf验证
        http.csrf().disable()
                // 对请求进行认证
                .authorizeRequests()
                // 所有 / 的所有请求 都放行
                .antMatchers("/").permitAll()
                // 所有 /login 的POST请求 都放行
//                .antMatchers(HttpMethod.POST, "/User/login").permitAll()
//                .antMatchers(HttpMethod.POST,"/Show/type/{type}").permitAll()
//                .antMatchers(HttpMethod.POST,"/Show/id/{id}").permitAll()
//                .antMatchers(HttpMethod.POST,"/Venue/register").permitAll()
//                .antMatchers(HttpMethod.POST, "/Venue/login").permitAll()
//                .antMatchers(HttpMethod.POST, "/Manage/checkList").permitAll()
//                .antMatchers(HttpMethod.POST,"/Manage/email/{venueId}").permitAll()
//                .antMatchers(HttpMethod.GET,"/Manage/active").permitAll()
                // 权限检查
//                .antMatchers("/User/hello").hasAuthority("AUTH_WRITE")
//                // 角色检查
//                .antMatchers("/User/world").hasRole("ADMIN")
                // 所有请求需要身份认证
                .anyRequest().permitAll()
                .and()
                // 添加一个过滤器 所有访问 /login 的请求交给 JWTLoginFilter 来处理 这个类处理所有的JWT相关内容
                .addFilterBefore(new JWTLoginFilter("/User/hello", authenticationManager()),
                        UsernamePasswordAuthenticationFilter.class)
                // 添加一个过滤器验证其他请求的Token是否合法
                .addFilterBefore(new JWTAuthenticationFilter(),
                        UsernamePasswordAuthenticationFilter.class);
    }

    //    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        // 使用自定义身份验证组件
//        auth.authenticationProvider(new CustomAuthenticationProvider());
//    }
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(customAuthenticationProvider);
    }
}
