package com.lanou.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * MainController
 */

/**
 * @Controller :  代表当前类是一个控制器, 类似于Struts2的Action
 * 当浏览器发出请求时HandlerMapper会进行匹配访问路径是否在这个类中定义了
 */
@Controller
public class MainController {


//    /**
//     * @RequestMapping : 定义能处理的请求路径
//     * 例如: localhost:8080/home
//     * 返回的视图, 根据spring配置文件中的视图解析定义自动加上前缀和后缀
//     * 即方法/home时, 跳转的页面为: localhost:8080/WEB-INF/pages/home.jsp
//     */
//    @RequestMapping(value = "/home")
//    public String home() {
//        System.out.println("访问了home");
//        return "home";
//    }


    /**
     * 处理index的访问请求
     */
    @RequestMapping(value = "/index")
    public String index() {
        return "index";
    }

    /**
     * 跳转到登录界面
     * 请求路径: /login
     * 返回视图: /WEB-INF/pages/user/login.jsp
     */
    @RequestMapping(value = "/login")
    public String login(HttpServletRequest request) {
        request.getServletContext().removeAttribute("loginUser");
        return "user/login";
    }


    /**
     * 跳转到注册页面
     * 请求路径: /register?username=jaso&password=123
     * 返回视图: /WEB-INF/pages/user/register.jsp
     */
    @RequestMapping(value = "/register")
    public String register(
            String uname, Model model) {

        /*用于页面回显时存储数据的对象*/
        model.addAttribute("username", uname);

        return "user/register";
    }


    /**
     * 进入新建博客界面
     */
    @RequestMapping(value = "/addblog")
    public String addblog() {
        return "blog/addblog";
    }


}
