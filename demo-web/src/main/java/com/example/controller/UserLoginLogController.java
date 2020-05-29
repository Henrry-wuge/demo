package com.example.controller;

import com.example.base.Response;
import com.example.service.UserLoginLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/userLoginLog")
public class UserLoginLogController {

    @Autowired
    private UserLoginLogService userLoginLogService;

    @RequestMapping(value = "/list")
    @ResponseBody
    public Response list() {
        return Response.builder().success().data(userLoginLogService.list());
    }
}
