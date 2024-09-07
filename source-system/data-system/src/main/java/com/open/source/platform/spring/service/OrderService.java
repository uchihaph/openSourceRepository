package com.open.source.platform.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

public class OrderService {

    private UseService useService;

    @PostConstruct
    public void wr(){
        System.out.println("postConstruct");
    }

    @Autowired
    public void sasdf(UseService useService) {

        this.useService = useService;
        System.out.println(this.useService+"###");
    }

}
