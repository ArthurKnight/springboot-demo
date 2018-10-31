package com.example.demo.controller;

import com.example.demo.entity.Dog;
import org.springframework.format.datetime.DateFormatter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;

/**
 * @author Arthur
 * @date 2018-10-15
 */
@Controller
public class HelloSpringBootController {

    /**
     * Spring视图默认保存在resources/templates目录下
     *
     * @return
     */
    @RequestMapping(value = "/index")
    public String index(Model model) {
        model.addAttribute("name","hello,world");
        return "/index.btl";
    }

    /**
     * 默认是返回视图名称，返回JSON字符串需要使用注解@ResponseBody，如果是字符串直接返回，如果不是默认使用Jackson序列化成JSON字符串后输出
     * @param id
     * @return
     */
    @RequestMapping("/userdetail")
    @ResponseBody
    public String foo(String id) {
        return "/admin/userInfo.btl";
    }

    @RequestMapping("/obj")
    @ResponseBody
    public Dog obj() {
        Dog dog = new Dog();
        dog.setAge(1);
        dog.setName("Wang");
        return dog;
    }

    @PostMapping(path = "/saveObj.json")
    @ResponseBody
    public String saveObj(@RequestBody Dog dog){
        return dog.getName();
    }

    /**
     * 单文件上传
     */
    @PostMapping("/form")
    @ResponseBody
    public String handleFormUpload(String name, MultipartFile file) throws IOException{
        if (!file.isEmpty()) {
            String fileName = file.getOriginalFilename();
            InputStream ins = file.getInputStream();
            //处理上传内容
            return "success";
        }
        return "failure";
    }

    /**
     * 多文件上传
     * 这要求http请求中包含多个name="files" 的文件
     */
    @PostMapping("/filesUpload")
    @ResponseBody
    public String filesUpload(String name, MultipartFile[] files) throws IOException{
        return "failure";
    }

    /*@ModelAttribute
    public void findUserById(@PathVariable Integer id, Model model) {
        model.addAttribute("user",1111);
    }*/

   /* @GetMapping("/{id}/get.json")
    @ResponseBody
    public String getUser(Model model) throws IOException {
        boolean isContains = model.containsAttribute("user");
        System.out.println(isContains);
        return "success";
    }*/

    @InitBinder
    protected void initBinder(WebDataBinder binder) {
        binder.addCustomFormatter(new DateFormatter("yyyy-MM-dd"));
    }

    @ResponseBody
    @RequestMapping("/date")
    public void printDate(Date d){
        System.out.println(d);
        return;
    }

}

