package com.wjj.security.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.wjj.security.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import javax.sql.DataSource;
import java.io.PrintWriter;

/**
 * @Author wjj
 * @create 2021/11/30
 * @Description
 *
 *
 * 登录配置介绍：
 * web.ignoring() 用来配置忽略掉的 URL 地址，一般对于静态文件，我们可以采用此操作。
 * 如果我们使用 XML 来配置 Spring Security ，里边会有一个重要的标签 <http>，HttpSecurity 提供的配置方法 都对应了该标签。
 * authorizeRequests 对应了 <intercept-url>。
 * formLogin 对应了 <formlogin>。
 * and 方法表示结束当前标签，上下文回到HttpSecurity，开启新一轮的配置。
 * permitAll 表示登录相关的页面/接口不要被拦截。
 * 最后记得关闭 csrf ，关于 csrf 问题我到后面专门和大家说。
 * defaultSuccessUrl、successForwardUrl 这两个都是配置跳转地址的，适用于前后端不分的开发
 * successHandler 甚至已经囊括了 defaultSuccessUrl 和 successForwardUrl 的功能
 * authentication 参数则保存了我们刚刚登录成功的用户信息
 *
 * 注销配置介绍logout：
 * 默认注销的 URL 是 /logout，是一个 GET 请求，我们可以通过 logoutUrl 方法来修改默认的注销 URL。
 * logoutRequestMatcher 方法不仅可以修改注销 URL，还可以修改请求方式，实际项目中，这个方法和 logoutUrl 任意设置一个即可。
 * logoutSuccessUrl 表示注销成功后要跳转的页面。
 * deleteCookies 用来清除 cookie。
 * clearAuthentication 和 invalidateHttpSession 分别表示清除认证信息和使 HttpSession 失效，默认可以不用配置，默认就会清除。
 *
 */
@Configuration
public class SercurityConfig extends WebSecurityConfigurerAdapter {


    @Autowired
    DataSource dataSource;

    @Bean
    PasswordEncoder passwordEncoderConfig(){
        return new BCryptPasswordEncoder();
    }

  /*  @Bean
    protected UserDetailsService userDetailsServiceConfig(){
        JdbcUserDetailsManager manager = new JdbcUserDetailsManager(dataSource);
        return manager;
    }*/

    @Bean
    JdbcTokenRepositoryImpl jdbcTokenRepository() {
        JdbcTokenRepositoryImpl jdbcTokenRepository = new JdbcTokenRepositoryImpl();
        jdbcTokenRepository.setDataSource(dataSource);
        return jdbcTokenRepository;
    }

    @Autowired
    UserService userService;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userService);
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/js/**", "/css/**","/images/**");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/createUser").permitAll()//资源放行
//                .antMatchers("/admin/**").hasRole("admin")//根据url角色配置  上往下的顺序来匹配
//                .antMatchers("/user/**").hasRole("user")
//                .antMatchers("/druid").hasRole("dev")
                .anyRequest().authenticated()
                .and()
                .rememberMe()
                .key("gudingkey")//默认key是uuid，每次服务重启都会导致原有的token失效，记住我也需要重新登录，固定值ok
                .tokenRepository(jdbcTokenRepository())
                .and()
                .formLogin()
                .loginPage("/login.html")
                /*.loginProcessingUrl("/doLogin")//设置登录接口名称
                .usernameParameter("name")//设置登录用户名key值   默认username
                .passwordParameter("passwd")//设置登录密码key值   默认password*/
//                .defaultSuccessUrl("/index")
//                .successForwardUrl("/index")//登录成功后的回调  用于前后端不分离
                .successHandler((req, resp, authentication) ->{
                    Object principal = authentication.getPrincipal();
                    resp.setContentType("application/json;charset=utf-8");
                    PrintWriter out = resp.getWriter();
                    out.write(new ObjectMapper().writeValueAsString(principal));
                    out.flush();
                    out.close();
                })
                .failureHandler((req, resp, e) -> {
                    resp.setContentType("application/json;charset=utf-8");
                    PrintWriter out = resp.getWriter();
                    out.write(e.getMessage());
                    out.flush();
                    out.close();
                })
                .permitAll()
                .and()
                .logout()//注销登录
//                .logoutUrl("/logout")
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout","POST"))
//                .logoutSuccessUrl("/index")
                .logoutSuccessHandler((req, resp, authentication) -> {
                    resp.setContentType("application/json;charset=utf-8");
                    PrintWriter out = resp.getWriter();
                    out.write("注销成功");
                    out.flush();
                    out.close();
                })//前后端分离，返回前端json
                .deleteCookies()
//                .clearAuthentication(true)
//                .invalidateHttpSession(true)
                .permitAll()
                .and()
                .csrf().disable().exceptionHandling()
                .authenticationEntryPoint((req, resp, authException) -> {
                            resp.setContentType("application/json;charset=utf-8");
                            PrintWriter out = resp.getWriter();
                            out.write("尚未登录，请先登录");
                            out.flush();
                            out.close();
                        }
                );
    }
}
