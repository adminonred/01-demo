package com.cn.controller;

import com.cn.model.User;
import com.cn.service.MyService;
import com.cn.service.imp.MyServiceImp;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class MyController {
    @Resource
    MyServiceImp myService;
    @GetMapping("/get")
    public String get(Model model){
        model.addAttribute("users",myService.select());
        return "get";
    }
    @PostMapping("/in")
    @ResponseBody
    public String in(HttpServletRequest request){
        String name=(String)request.getParameter("name");
        Integer age=Integer.parseInt(request.getParameter("age"));
        User user=new User();
        user.setName(name);
        user.setAge(age);
        boolean flag=myService.query(user);
        return user.toString()+"插入"+flag;
    }
    @GetMapping("/drop")
    @ResponseBody
    public String drop(int id){
        boolean flag=myService.delete(id);
        return "删除用户：id="+id+flag;
    }
    @GetMapping("/update")
    @ResponseBody
    public String update(int age,String name){
        boolean flag=myService.update(age,name);
        return "更新数据"+flag;
    }
    @GetMapping("/each")
    public String each(Model model){
        List<User> users=myService.select();
        model.addAttribute("users",users);
        return "each";
    }
    @GetMapping("/ifunless")
    public String ifunless(Model model){
        model.addAttribute("age",50);
        return "ifunless";
    }
    @GetMapping("/usefragment")
    public String fragment(){
        return "usefragment";
    }
    @GetMapping("/ajax")
    @ResponseBody
    public String ajax(){
        return "ajax成功执行";
    }
}
