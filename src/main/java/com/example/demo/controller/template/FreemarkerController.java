package com.example.demo.controller.template;

import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * 默认情况下SpringBoot的Freemarker模版引擎为视图添加ftl后缀来寻找匹配的模版
 *
 * @author Arthur
 * @date 2018-10-25
 */
@Controller
@RequestMapping("/freemarker")
public class FreemarkerController {

    @Autowired
    UserService userService;

    @GetMapping("/showuser")
    public ModelAndView showUserInfo(Long id) {
        ModelAndView view = new ModelAndView();
        User user = userService.getUserById(id);
        view.addObject("user", user);
        view.setViewName("/userInfo");
        System.out.println("hello111");
        return view;
    }

}
