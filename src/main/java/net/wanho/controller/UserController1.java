package net.wanho.controller;

import com.alibaba.fastjson.JSONObject;
import net.wanho.entity.User;
import net.wanho.service.UserService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class UserController1 {

    @Resource
    private UserService userService;
    @RequestMapping(value="/user",method = RequestMethod.GET)
    public JSONObject queryList()
    {
        List<User> list =  userService.queryUsers();
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("data",list);
        jsonObject.put("status",200);
        return jsonObject;
    }

    @RequestMapping(value = "/user/{id}",method = RequestMethod.GET)
    public JSONObject queryById(@PathVariable("id") int id)
    {
        User user = userService.getUserById(id);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("data",user);
        jsonObject.put("status",200);
        return jsonObject;
    }

    @RequestMapping(value="/user/{name}",method = RequestMethod.POST)
    public JSONObject insertUser(@PathVariable("name")String name)
    {
        userService.insertUser(name);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("status",200);
        return jsonObject;
    }

    @RequestMapping(value="/user/{id}",method = RequestMethod.DELETE)
    public JSONObject deleteUser(@PathVariable("id")int  id)
    {
        userService.delete(id);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("status",200);
        return jsonObject;
    }

    @RequestMapping(value="/user/{id}/{name}",method = RequestMethod.PUT)
    public JSONObject updateUser(@PathVariable("id")int  id,@PathVariable("name")String name)
    {
        userService.update(id,name);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("status",200);
        return jsonObject;
    }

}
