package com.open.source.platform.controller;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author hanguo
 * @date 2021/12/27
 * @Description 检查健康度
 */
@RestController
public class checkController {

    private static Log log = LogFactory.getLog(checkController.class);

    @RequestMapping("/check")
    public String method(){
        log.info("日志打印下");
        return "this is so health！！！";
    }

    @RequestMapping("/testRequest")
    public String testRequest(@Autowired HttpServletRequest request, @Autowired HttpServletResponse response){

        request.getMethod();
        response.getClass();
        return "ok";
    }

}
