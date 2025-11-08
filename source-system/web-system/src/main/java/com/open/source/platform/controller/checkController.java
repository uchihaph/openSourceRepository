package com.open.source.platform.controller;


import com.alibaba.fastjson.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.GetMapping;
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
@RequestMapping("/check")
public class checkController {

    private static Log log = LogFactory.getLog(checkController.class);

    @GetMapping("/log")
    public String method(){
        log.info("日志打印下");
        return "this is so health！！！";
    }

    @GetMapping("/health")
    public JSONObject testRequest(@Autowired HttpServletRequest request, @Autowired HttpServletResponse response){

        request.getMethod();
        response.getClass();
        return JSONObject.parseObject("{\"status\":\"200\",\"message\":\"操作成功\"}");
    }

}
