package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Controller
public class addController {
    public List<linkman> linkmanList = new ArrayList<>();
    int edit_id = 0;
    @RequestMapping("/table")
    public ModelAndView table(Model model){
        model.addAttribute("linkman",linkmanList);//返回联系人列表
        ModelAndView MV = new ModelAndView("table","linkmanlist",model);
        return  MV;
    }

    @RequestMapping("/login")
    public String login(Model model){
        return "login";
    }

    @RequestMapping("/add")//点击添加按钮之后，利用ModelAndView，由控制器生成一个linkman实例对象返回给add.html
    public String add(Model model){
        return "add";
    }

    @RequestMapping(value = "/add/post")
    public String add_post(@RequestParam("name") String name,//获取表单提交的内容
                           @RequestParam("tel") String tel,
                           @RequestParam("mail") String mail,
                           @RequestParam("address") String address,
                           @RequestParam("qq") String qq,
                           Model model){
        linkman l = new linkman(name,tel,mail,address,qq);

        linkmanList.add(l);//将提交的联系人对象加入列表
        return "redirect:/table";
    }
    @RequestMapping(value = "/table/edit/{edit_name}")
    public ModelAndView edit(@PathVariable("edit_name")String edit_name, Model model){
        Iterator<linkman> iterator =linkmanList.iterator();
        int id = 0;
        while(iterator.hasNext()){
            linkman current =iterator.next();
            if(edit_name.equals(current.name)){
                model.addAttribute("linkman",current);
                edit_id = id;
                break;
            }
            id ++;
        }
        ModelAndView MV = new ModelAndView("edit","info",model);
        return MV;
    }
    @RequestMapping(value = "/table/delete/{delete_name}")
    public String delete(@PathVariable("delete_name")String delete_name,Model model){
        Iterator<linkman> iterator =linkmanList.iterator();
        int id = 0;
        while(iterator.hasNext()){
            linkman current =iterator.next();
            if(delete_name.equals(current.name)){
                linkmanList.remove(id);
                break;
            }
            id++;
        }
        return  "redirect:/table";
    }

    @RequestMapping(value = "edit/post/{edit_name}")
    public String edit_post(@RequestParam("name") String name,//获取表单提交的内容
                            @RequestParam("tel") String tel,
                            @RequestParam("mail") String mail,
                            @RequestParam("address") String address,
                            @RequestParam("qq") String qq,
                            Model model){
        linkman l= new linkman(name,tel,mail,address,qq);
        linkmanList.set(edit_id,l);
        return  "redirect:/table";
    }
}