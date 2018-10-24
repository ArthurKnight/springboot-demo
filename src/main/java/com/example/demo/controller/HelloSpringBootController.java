package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author Arthur
 * @date 2018-10-15
 */
@Controller
public class HelloSpringBootController {

    /**
     * Spring视图默认保存在resources/templates目录下
     * @return
     */
    @RequestMapping(value = "/index")
    public
    @ResponseBody
    String index(Model model) {
        model.addAttribute("name","hello,world");
        return "/index.btl";
    }

    @RequestMapping("/userdetail")
    public String foo(String id) {
        return "/admin/userInfo.btl";
    }
}

