package com.ky.controoler;

import com.github.pagehelper.PageInfo;
import com.ky.pojo.User;
import com.ky.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/hello")
    public String hello(){
        return "spring boot 他大爷的";
    }

    @RequestMapping("/select")
    @ResponseBody
    public List<User> select(){
        return userService.selectAll();
    }

    @RequestMapping("/page")
    @ResponseBody
    public PageInfo<User> page(@RequestParam(name="page",defaultValue = "1")int page,
                           @RequestParam(name="rows",defaultValue = "2")int rows  ){

        PageInfo<User> pageInfo = userService.page(page,rows);
        System.out.println("hello");
        return pageInfo;
    }


    @RequestMapping("/list")
    public String list(Model model){
        model.addAttribute("list",userService.selectAll());
        return "list";
    }
}
