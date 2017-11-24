package com.lanou.controller;

import com.lanou.domain.Blog;
import com.lanou.domain.BlogExt;
import com.lanou.domain.User;
import com.lanou.response.AjaxLoginResult;
import com.lanou.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by dllo on 17/11/10.
 */

@Controller
public class UserController {

    /**
     * 持有的服务层对象
     */
    @Autowired
    @Qualifier("userService")
    private UserService userService;

    /**
     * 处理登录请求的登录, 返回json数据
     *
     * @ResponseBody :  声明当前请求返回的数据为json数据
     */
    @ResponseBody
    @RequestMapping(value = "/loginu")
    public AjaxLoginResult loginu(
            @Validated
                    User user,
            BindingResult vResult,
            HttpServletRequest request) {

        AjaxLoginResult result = new AjaxLoginResult();
        /*判断user对象输入验证的结果是否为空*/
        if (vResult.hasErrors()) {
            result.setErrorCode(404);
            result.setMessage("*请填写完整信息!");
        } else {

            User user1 = userService.findByName(user);
            System.out.println("查询到的对象" + user1);

            if (user1 != null) {
                //正确信息模拟
                result.setErrorCode(0);
                result.setData(user1);
                request.getServletContext().setAttribute("loginUser", user1);//
            } else {
                //错误信息模拟
                result.setErrorCode(404);
                result.setMessage("*用户 : " + user.getName() + "账号或密码错误!");
            }
        }

        return result;

    }

    /**
     * 注册
     */
    @ResponseBody
    @RequestMapping(value = "/newuser")
    public AjaxLoginResult newuser(
            @Validated
            User user,
            BindingResult vResult) {
        AjaxLoginResult result = new AjaxLoginResult();
        if (vResult.hasErrors()) {
            result.setErrorCode(404);
            result.setMessage("*请填写完整信息!");
        } else {

            int i = userService.addUser(user);

            if (i > 0) {
                result.setErrorCode(0);
                result.setMessage("注册成功!");
            }
        }

        return result;
    }

    /**
     * 请求进入博客界面
     *
     * @PathVariable : 获取路径中同名的对象值
     */
    @RequestMapping(value = "/blogpage/{userId}")
    public String blogpage(
            @PathVariable
                    Integer userId,
            String content,
            Model model) {
        System.out.println("登录用户id : " + userId);

        BlogExt blogExt = new BlogExt();
        blogExt.setUid(userId);

        //构建博客对象集合
        List<Blog> blogList = userService.findBlogByCotnt(blogExt);

        //将博客集合对象保存到model(属性名与界面一致)
        model.addAttribute("bloglist", blogList);

        return "blog/blogpage";
    }

    /**
     * 高级搜索
     */
    @RequestMapping("/search")
    public String search(String content, Integer userId, Model model) {
        BlogExt blogExt = new BlogExt();
        blogExt.setUid(userId);
        if (!"".equals(content)){
            blogExt.setContent(content);
        }
        List<Blog> blogList = userService.findBlogByCotnt(blogExt);

        //将博客集合对象保存到model(属性名与界面一致)
        model.addAttribute("bloglist", blogList);

        return "blog/blogpage";
    }
    /**
     * 博客详情
     */
    @RequestMapping(value = "/blogdetail/{blogId}")
    public String blogdetail(
            @PathVariable
                    Integer blogId, Model model) {
        Blog blog = userService.findBlog(blogId);
        model.addAttribute("blog", blog);
        return "blog/blogdetail";
    }


    /**
     * 新建博客
     */
    @ResponseBody
    @RequestMapping(value = "/newblog")
    public AjaxLoginResult newblog(Blog blog) {

        int i = userService.addBlog(blog);
        AjaxLoginResult result = new AjaxLoginResult();
        if (i > 0) {
            result.setErrorCode(0);
            result.setMessage("发表成功!");
        }

        return result;
    }

    /**
     * 删除微博
     */
    @ResponseBody
    @RequestMapping(value = "/deleteblog")
    public AjaxLoginResult deleteblog(Blog blog) {

        int i = userService.deleteBlog(blog);
        AjaxLoginResult result = new AjaxLoginResult();
        if (i > 0) {
            result.setErrorCode(0);
            return result;
        }
        return null;
    }



    /**
     * 进入编辑界面
     */
    @RequestMapping("/updateblog/{blogId}")
    public String updateblog(
            @PathVariable
                    Integer blogId, Model model) {
        Blog blog = userService.findBlog(blogId);
        model.addAttribute("blog", blog);
        return "blog/updateblog";
    }

    /**
     * 编辑博客
     */
    @ResponseBody
    @RequestMapping("/newBlog")
    public AjaxLoginResult newBlog(Blog blog) {
        int i = userService.updateBlog(blog);
        AjaxLoginResult result = new AjaxLoginResult();
        if (i > 0) {
            result.setErrorCode(0);
            return result;
        }
        return null;

    }

}
