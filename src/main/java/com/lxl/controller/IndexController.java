package com.lxl.controller;

import com.lxl.service.UserService;
import com.lxl.vo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Map;

/**
 * @Author lixiaolong
 * @Description:
 * @Date 2018/3/27
 */
@Controller
public class IndexController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/index/{id}", method = RequestMethod.GET)
    public String index(@PathVariable("id") Integer id, Map<String, User> map) {
        map.put("user", userService.selectUserById(id));
        return "index";
    }
}