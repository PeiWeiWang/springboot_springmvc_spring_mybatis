package net.wanho.controller;

import com.alibaba.fastjson.JSONObject;
import net.wanho.entity.Permission;
import net.wanho.entity.User;
import net.wanho.service.UserService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

//@Controller
@RequestMapping("/mybatis")
public class UserController {

    @Resource
    private UserService userService;
    @RequestMapping("/queryuser")
    public ModelAndView queryList()
    {
        List<User> list =  userService.queryUsers();
        ModelAndView modelAndView = new ModelAndView("success");
        modelAndView.addObject("list",list);
        return modelAndView;
    }

    @RequestMapping("/querypermissions")
    @ResponseBody
    public JSONObject queryPermission()
    {
        JSONObject jsonObject = new JSONObject();

        List<Permission> list = new ArrayList<>();

        list.add(new Permission(1,"一级权限",0,"user:add"));
        list.add(new Permission(2,"2级权限",1,"user:add2",true,true));
        list.add(new Permission(3,"3级权限",2,"user:add3"));

        jsonObject.put("zNodes",list);
        return jsonObject;
    }

    @RequestMapping("/subpermissions")
    @ResponseBody
    public JSONObject subpermissions(@RequestParam(value = "nodes",required = false) String nodes)
    {
        JSONObject jsonObject = new JSONObject();


        return jsonObject;
    }

    @RequestMapping("/testrans")
    @ResponseBody
    public String test1(int id)
    {
        userService.delete(id);
        return "1234";
    }

}
